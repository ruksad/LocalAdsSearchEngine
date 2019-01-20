package com.yellowpages.service.implementations;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.services.s3.transfer.MultipleFileDownload;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import com.amazonaws.util.IOUtils;
import com.yellowpages.log.annotation.Trace;
import com.yellowpages.log.eventtype.LogEventType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
public class AmazonClient {

    private AmazonS3 amazonS3Client;
    private AWSCredentials credentials;


//    @Value("${}")
//    private String downloadFolder;
    @Value("${aws.bucket.url}")
    private String bucketEndPoint;

    @Value("${aws.bucket.name}")
    private String bucketName;

    @Value("${aws.bucket.accessKey}")
    private String accessKey;

    @Value("${aws.bucket.secretKey}")
    private String secretKey;

    @PostConstruct
    private void initializeAmazonClient(){
        this.credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
        this.amazonS3Client = new AmazonS3Client(credentials);
    }

    public String uploadFile(MultipartFile multipartFile,Long objectId,String categoryName) {
        String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = categoryName+"/"+String.valueOf(objectId) +"/"+generateFileName(multipartFile);
            fileUrl = bucketEndPoint + "/" + bucketName + "/" +fileName;
            PutObjectResult putObjectResult = uploadFileTos3bucket(fileName, file,fileName);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileUrl;
    }


    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }


    private String generateFileName(MultipartFile multiPart) {
        return multiPart.getOriginalFilename().trim();
    }

    private PutObjectResult uploadFileTos3bucket(String fileName, File file,String categoryName) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, categoryName, file);
        putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead);

        return amazonS3Client.putObject(putObjectRequest);
    }

    public String deleteFileFromS3Bucket(String fileUrl) {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        amazonS3Client.deleteObject(new DeleteObjectRequest(bucketName, fileName));
        return "Successfully deleted";
    }

    public void getAllFileFromAFolder(String withKey,String folderName){

//       // TransferManager transferManager = new TransferManager(new DefaultAWSCredentialsProviderChain());
//       S3Object s3Object = amazonS3Client.getObject(new GetObjectRequest(bucketName, folderName));
//        S3ObjectInputStream objectContent = s3Object.getObjectContent();
//        try {
//            IOUtils.copy(objectContent, new FileOutputStream("./test1.jpg"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        s3Object.getObjectContent();

//        TransferManager transferManager = new TransferManager(this.credentials);
//        File dir = new File(System.getProperty("java.io.tmpdir")+"/"+folderName);
//
//        MultipleFileDownload download =  transferManager.downloadDirectory(bucketName, folderName, dir);
//        try {
//            download.waitForCompletion();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

         List<String> filesForWithKeyAndFolderName = listAllTheFilesInBucketFolder(withKey, folderName);
        TransferManager transferManager = new TransferManager(this.credentials);
        File directory = new File("." + File.separator + folderName);
        if(directory.mkdir()) {
            MultipleFileDownload multipleFileDownload = transferManager.downloadDirectory(bucketName, withKey + "/" + folderName, directory);

            try {
                multipleFileDownload.waitForCompletion();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }catch (Exception e){
                log.error(e.getMessage());
            }
        }

    }

    @Trace(type = LogEventType.SERVICE)
    public void uploadAllFilesToAFolder(List<MultipartFile> files,String withKey,String folderName){
        TransferManager transferManager = new TransferManager(this.credentials);
        List<File> files1=new ArrayList<>(4);
        AtomicInteger fileId = new AtomicInteger(0);
        files.forEach(file->{
            try {

                ObjectMetadata objectMetadata=new ObjectMetadata();
                objectMetadata.setContentType(file.getContentType());
                objectMetadata.setContentLength(file.getSize());
                objectMetadata.setContentDisposition(String.valueOf(fileId.getAndIncrement())+".jpg");

                Upload upload = transferManager.upload(bucketName, withKey + "/" + folderName,file.getInputStream(),objectMetadata);
                upload.waitForCompletion();

            } catch (IOException e) {
                log.error(e.getMessage());
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }catch (Exception e){
                log.error(e.getMessage());
            }
        });


    }

    public List<String> listAllTheFilesInBucketFolder(String category,String folderName){
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
                .withBucketName(bucketName)
                .withPrefix(category+"/"+folderName).withDelimiter("/");
        ObjectListing objectListing = amazonS3Client.listObjects(listObjectsRequest);

        List<String> keys = new ArrayList<>();

        ObjectListing objects = amazonS3Client.listObjects(listObjectsRequest);
        for (;;) {
            List<S3ObjectSummary> summaries = objects.getObjectSummaries();
            if (summaries.size() < 1) {
                break;
            }
            summaries.forEach(s -> keys.add(s.getKey()));
            objects = amazonS3Client.listNextBatchOfObjects(objects);
        }

        return keys;
    }
}

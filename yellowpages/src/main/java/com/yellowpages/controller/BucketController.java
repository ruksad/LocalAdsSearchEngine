package com.yellowpages.controller;

import com.amazonaws.services.ec2.model.Storage;
import com.yellowpages.service.implementations.AmazonClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api
@RestController
@RequestMapping("/api/yellow-pages/v1/storage/")
public class BucketController {

    private AmazonClient amazonClient;

    @Autowired
    BucketController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("/uploadFile")
    @ApiOperation(value = "upload ile in bucket", nickname = "upload file")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonClient.uploadFile(file,121111L,"Vehicles");
    }

    @DeleteMapping("/deleteFile")
    @ApiOperation(value = "delete file from bucket", nickname = "delete file ")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }

    @GetMapping(value = "/GetFiles",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ApiOperation(value = "get all the file from s3 in a folder", nickname = "delete file ")
    public @ResponseBody List<byte[]> getAllFilefromAFolder(@RequestParam("objectTypeId") String objectTypeId
            ,@RequestParam("folderName") String folderName){
        this.amazonClient.getAllFileFromAFolder(folderName,objectTypeId);
        return null;
    }

    @PostMapping("/uploadFiles")
    @ApiOperation(value = "upload ile in bucket", nickname = "upload file")
    public ResponseEntity<?> uploadFile(@RequestParam(value = "files") List<MultipartFile> files,HttpServletRequest request) {
         this.amazonClient.uploadAllFilesToAFolder(files,"Vehicles","121112");
        return null;
    }
}
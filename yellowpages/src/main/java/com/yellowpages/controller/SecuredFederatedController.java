package com.yellowpages.controller;

import com.yellowpages.log.annotation.Trace;
import com.yellowpages.log.eventtype.LogEventType;
import com.yellowpages.model.ObjectEntity;
import com.yellowpages.model.dto.FlattenedObjectEntityDto;
import com.yellowpages.model.dto.PostAdDto;
import com.yellowpages.service.ObjectService;
import com.yellowpages.service.implementations.AmazonClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ruksad siddiqui on 7/4/18
 */
@Api
@RestController
@Slf4j
@RequestMapping(value = SecuredFederatedController.BASE_URL, produces = { MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*")
public class SecuredFederatedController {

    public static final String BASE_URL = "/api/yellow-pages/v1/authorize";

    private final ObjectService objectService;

    @Autowired
    public SecuredFederatedController(ObjectService objectService,AmazonClient amazonClient){
        this.objectService=objectService;
    }

    @ApiOperation(value = "Save new object", nickname = "post add")
    @PostMapping(path = "/save/object-for-object-type", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = FlattenedObjectEntityDto.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @Trace(type = LogEventType.CONTROLLER)
    public ResponseEntity<ObjectEntity> getObjectTypeByObjectIdAndCityId(@RequestBody PostAdDto postAdDto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(objectService.postAnAd(postAdDto));
    }
}

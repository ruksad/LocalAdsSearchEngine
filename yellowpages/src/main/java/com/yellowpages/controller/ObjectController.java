package com.yellowpages.controller;

import com.yellowpages.log.annotation.Trace;
import com.yellowpages.log.eventtype.LogEventType;
import com.yellowpages.model.ObjectEntity;
import com.yellowpages.model.dto.FlattenedObjectEntityDto;
import com.yellowpages.model.dto.PostAdDto;
import com.yellowpages.service.ObjectService;
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

import java.util.List;

/**
 * Created by Ruksad siddiqui on 31/1/18
 */
@Api
@RestController
@Slf4j
@RequestMapping(value = ObjectController.BASE_URL, produces = { MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*")
public class ObjectController {

  public static final String BASE_URL = "/api/yellow-pages/v1";

  private final ObjectService objectService;

  @Autowired
  public ObjectController(ObjectService objectService){
    this.objectService=objectService;
  }

  @ApiOperation(value = "get complete object by object id and city id", nickname = "get flattened Object")
  @GetMapping(path = "/find/object/object-details", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success", response = FlattenedObjectEntityDto.class),
          @ApiResponse(code = 404, message = "Not Found"),
          @ApiResponse(code = 500, message = "Failure")})
  @Trace(type = LogEventType.CONTROLLER)
  public ResponseEntity<FlattenedObjectEntityDto> getObjectTypeByObjectIdAndCityId(@RequestParam long objectId,@RequestParam long parentId){
    return ResponseEntity.status(HttpStatus.OK).body(objectService.findObjectByObjectIdAndParentId(objectId,parentId));
  }

  //TODO remove this later
  @ApiOperation(value = "get complete object by object name", nickname = "get rigid object")
  @PostMapping(path = "/find/object/objectName", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success", response = ObjectEntity.class),
          @ApiResponse(code = 404, message = "Not Found"),
          @ApiResponse(code = 500, message = "Failure")})
  @Trace(type = LogEventType.CONTROLLER)
  public ResponseEntity<List<ObjectEntity>> getObjectByObjectId(@RequestParam long objectId,@RequestParam long parentId){
      return ResponseEntity.status(HttpStatus.OK).body(objectService.findByObjectIdAndParentId(objectId,parentId));
  }

}

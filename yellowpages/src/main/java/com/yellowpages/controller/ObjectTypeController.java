package com.yellowpages.controller;

import com.yellowpages.log.annotation.Trace;
import com.yellowpages.log.eventtype.LogEventType;
import com.yellowpages.model.ObjectTypeEntity;
import com.yellowpages.model.dto.ObjectTypeDTO;
import com.yellowpages.service.ObjectTypeService;
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
 * Created by Ruksad siddiqui on 26/1/18
 */

@Api
@RestController
@Slf4j
@RequestMapping(value = ObjectTypeController.BASE_URL, produces = { MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*")
public class ObjectTypeController {

  public static final String BASE_URL = "/api/yellow-pages/v1/find/object-type";

  private final ObjectTypeService objectTypeService;

  @Autowired
  public ObjectTypeController(ObjectTypeService objectTypeService) {
    this.objectTypeService = objectTypeService;
  }


  @ApiOperation(value = "get object type by objectId", nickname = "getObjectType")
  @GetMapping(path = "/{objectTypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = ObjectTypeEntity.class),
      @ApiResponse(code = 404, message = "Not Found"),
      @ApiResponse(code = 500, message = "Failure")})
  @Trace(type = LogEventType.CONTROLLER)
  public ResponseEntity<ObjectTypeEntity> getObjectType(@PathVariable("objectTypeId") Long ObjectTypeId){
    return ResponseEntity.status(HttpStatus.OK).body(objectTypeService.findById(ObjectTypeId));
  }

  @ApiOperation(value = "get object type by objectId", nickname = "getObjectType")
  @GetMapping(path = "/all-categories", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success", response = ObjectTypeDTO.class),
          @ApiResponse(code = 404, message = "Not Found"),
          @ApiResponse(code = 500, message = "Failure")})
  @Trace(type = LogEventType.CONTROLLER)
  public ResponseEntity<List<ObjectTypeDTO>> getAllCategories(){
    return ResponseEntity.status(HttpStatus.OK).body(this.objectTypeService.collectCategories());
  }

  @ApiOperation(value = "get object types by parentId", nickname = "get by parentId")
  @GetMapping(path = "/object-type", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success", response = List.class),
          @ApiResponse(code = 404, message = "Not Found"),
          @ApiResponse(code = 500, message = "Failure")})
  @Trace(type = LogEventType.CONTROLLER)
  public ResponseEntity<List<ObjectTypeDTO>> getObjectType(@RequestParam("parentIds") List<Long> ids){
    return ResponseEntity.status(HttpStatus.OK).body(objectTypeService.findByParentId(ids));
  }


}

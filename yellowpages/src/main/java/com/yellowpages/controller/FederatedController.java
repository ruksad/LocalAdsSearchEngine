package com.yellowpages.controller;

import com.yellowpages.log.annotation.Trace;
import com.yellowpages.log.eventtype.LogEventType;
import com.yellowpages.model.dto.FindObjectsByCriterion;
import com.yellowpages.model.dto.FlattenedObjectEntityDto;
import com.yellowpages.model.dto.PostAdDto;
import com.yellowpages.model.dto.StatesAndCities;
import com.yellowpages.service.FederatedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Created by Ruksad siddiqui on 31/1/18
 */
@Api
@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping(value = ObjectController.BASE_URL, produces = { MediaType.APPLICATION_JSON_VALUE})
public class FederatedController {

  public static final String BASE_URL = "/api/yellow-pages/v1/find/federated";
  FederatedService federatedService;

  @Value("#{'${yellowpages.categories.toList}'.split(',')}")
  private List<String> allCategories;

  @Autowired
  public FederatedController(FederatedService federatedService){
   this.federatedService=federatedService;
  }

  @ApiOperation(value = "fetches all the states and cities", nickname = "states and cities")
  @GetMapping(path = "/getStatesAndCities", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = StatesAndCities.class),
      @ApiResponse(code = 404, message = "Not Found"),
      @ApiResponse(code = 500, message = "Failure")})
  @Trace(type = LogEventType.CONTROLLER)
  public ResponseEntity<StatesAndCities> getStatesAndCities(){
    return ResponseEntity.status(HttpStatus.OK).body(this.federatedService.getPreRequisitePrepared());
  }


  @ApiOperation(value = "get object's name list", nickname = "get objectType string")
  @GetMapping(path = "/{object-type-name}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = Set.class),
      @ApiResponse(code = 404, message = "Not Found"),
      @ApiResponse(code = 500, message = "Failure")})
  @Trace(type = LogEventType.CONTROLLER)
  public ResponseEntity<Set<String>> getObjectsNameByObjectTypeName(@PathVariable("object-type-name") String objectTypeName){
    return ResponseEntity.status(HttpStatus.OK).body(this.federatedService.findObjectNamesByObjectTypeName(objectTypeName));
  }


  @ApiOperation(value = "get all objects name and description by criteria", nickname = "get objects criteria")
  @GetMapping(path = "/criteria", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = FlattenedObjectEntityDto.class),
      @ApiResponse(code = 404, message = "Not Found"),
      @ApiResponse(code = 500, message = "Failure")})
  @Trace(type = LogEventType.CONTROLLER)
  public ResponseEntity<List<FlattenedObjectEntityDto>> fetchResultsByCriteria(
          @RequestParam("stateId") Long stateId,
          @RequestParam("selectedCityId") Long selectedCityId,
          @RequestParam("categoryId") Long categoryId,
          @RequestParam(value = "localityId",required = false) Long localityId){
    FindObjectsByCriterion criteria=new FindObjectsByCriterion();
    criteria.setSelectedCityId(selectedCityId);
    criteria.setStateId(stateId);
    criteria.setCategoryId(categoryId);
    criteria.setLocalityId(localityId);
  return ResponseEntity.status(HttpStatus.OK).body(this.federatedService.getCriteriaMatchingObjects(criteria));
  }



  @ApiOperation(value = "get all objects name and description by city and parameters for featured", nickname = "get objects of featured cards")
  @GetMapping(path = "/featured-cards", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success", response = Set.class),
          @ApiResponse(code = 404, message = "Not Found"),
          @ApiResponse(code = 500, message = "Failure")})
  @Trace(type = LogEventType.CONTROLLER)
  public ResponseEntity<List<FlattenedObjectEntityDto>> getAllFeaturedCards(@RequestParam long objectParentId){

    return ResponseEntity.status(HttpStatus.OK).body(this.federatedService.getAllFeaturedCardsById(objectParentId));
  }


  @ApiOperation(value = "get all attributes for posting add", nickname = "get attributes for post ad")
  @GetMapping(path = "/get-post-ad-template", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success", response = PostAdDto.class),
          @ApiResponse(code = 404, message = "Not Found"),
          @ApiResponse(code = 500, message = "Failure")})
  @Trace(type = LogEventType.CONTROLLER)
  public ResponseEntity<PostAdDto> getPostAdDto(@RequestParam long objectLevel2Id,
                                                @RequestParam long objectLevel3Id,
                                                @RequestParam String objectTypeName,
                                                @RequestParam(required = false) Long  objectLevel4Id
                                                ){

    return ResponseEntity.status(HttpStatus.OK).body(this.federatedService.getPostAdDto(objectLevel2Id,objectLevel3Id,objectTypeName,objectLevel4Id));
  }

  @ApiOperation(value = "fetch user registration template", nickname = "get attributes for user registration")
  @GetMapping(path = "/get-add-user-template", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success", response = PostAdDto.class),
          @ApiResponse(code = 404, message = "Not Found"),
          @ApiResponse(code = 500, message = "Failure")})
  @Trace(type = LogEventType.CONTROLLER)
  public ResponseEntity<PostAdDto> fetchUserRegistrationTemplate(  ){

    return ResponseEntity.status(HttpStatus.OK).body(this.federatedService.getUserRegistrationTemplate());
  }

  @ApiOperation(value = "get all categories yellow pages support", nickname = "get categories")
  @GetMapping(path = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success", response = List.class),
          @ApiResponse(code = 404, message = "Not Found"),
          @ApiResponse(code = 500, message = "Failure")})
  @Trace(type = LogEventType.CONTROLLER)
  public ResponseEntity<List<String>> getAllCategories(){
    return ResponseEntity.status(HttpStatus.OK).body(allCategories);
  }
}

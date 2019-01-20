package com.yellowpages.security.controller;

import java.util.List;

import com.yellowpages.controller.SecuredFederatedController;
import com.yellowpages.log.annotation.Trace;
import com.yellowpages.log.eventtype.LogEventType;
import com.yellowpages.model.ObjectEntity;
import com.yellowpages.model.dto.FlattenedObjectEntityDto;
import com.yellowpages.model.dto.PostAdDto;
import com.yellowpages.security.JwtTokenUtil;
import com.yellowpages.security.model.JwtUser;
import com.yellowpages.security.service.CustomUserDetailsService;
import com.yellowpages.service.ObjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ruksad siddiqui on 7/4/18
 */
@Api
@RestController
@Slf4j
@RequestMapping(value = UserRestController.BASE_URL, produces = { MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*")
public class UserRestController {

    public static final String BASE_URL = "/api/yellow-pages/v1/user";

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    private final ObjectService objectService;

    @Autowired
    public UserRestController(ObjectService objectService){
        this.objectService=objectService;
    }



    @RequestMapping(value = "user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) customUserDetailsService.loadUserByUsername(username);
        return user;
    }


    @ApiOperation(value = "Register new User", nickname = "User registration")
    @PostMapping(path = "/registration", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ObjectEntity.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @Trace(type = LogEventType.CONTROLLER)
    public ResponseEntity<ObjectEntity> getObjectTypeByObjectIdAndCityId(@RequestBody PostAdDto postAdDto){
        return ResponseEntity.status(HttpStatus.OK).body(objectService.registerNewUser(postAdDto));
    }
    
    @ApiOperation(value = "get User Details based on Mobile number or Eamil", nickname = "get User")
    @GetMapping(path = "/verification", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = FlattenedObjectEntityDto.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure")})
    @Trace(type = LogEventType.CONTROLLER)
    public ResponseEntity<List<FlattenedObjectEntityDto>> checkingUserExistence(
            @RequestParam("mobileNumberOrEmail") String mobileNumberOrEmail){
    return ResponseEntity.status(HttpStatus.OK).body(objectService.verifyUser(mobileNumberOrEmail));
    }

}

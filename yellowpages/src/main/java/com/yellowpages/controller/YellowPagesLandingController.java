package com.yellowpages.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Ruksad siddiqui on 1/2/18
 */
@Slf4j
@Controller
@CrossOrigin(origins = "*")
public class YellowPagesLandingController {

  @Autowired
  private BuildProperties buildProperties;

  @GetMapping(value = {"/", "/portal/"})
  public String home(Model model, HttpServletRequest request, HttpServletResponse response) {
    log.info("inside home controller");
    response.setHeader("build-version", buildProperties.getVersion());
    response.setHeader("build-time", String.valueOf(buildProperties.getTime()));
    return "index";
  }
}

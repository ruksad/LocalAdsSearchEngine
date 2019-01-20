package com.yellowpages.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

/**
 * Created by Ruksad siddiqui on 1/2/18
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.yellowpages")
public class WebConfig extends WebMvcConfigurerAdapter {


  @Value("${cors.allowed.origins}")
  private String[] allowedOrigins;

  @Value("${cors.allowed.methods}")
  private String[] allowedMethods;

  @Value("${cors.exposed.headers}")
  private String[] exposedHeaders;

  @Value("${cors.allowed.header}")
  private String[] allowedHeaders;


  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    if (!registry.hasMappingForPattern("/dist/**")) {
      registry.addResourceHandler("/dist/**").addResourceLocations("classpath:/dist/");
    }
    if (!registry.hasMappingForPattern("/**")) {
      registry.addResourceHandler("/**").addResourceLocations("classpath:/dist/");
    }

  }


  @Bean
  public InternalResourceViewResolver internalViewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/dist/");
    viewResolver.setSuffix(".html");
    viewResolver.setOrder(2);
    return viewResolver;
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")

            .allowedHeaders(allowedHeaders)
            .allowedMethods(allowedMethods)
            .exposedHeaders(exposedHeaders)
            .maxAge(3600);
  }

  @Bean
  public FilterRegistrationBean simpleWebFilter() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(new Webfilter());
    registration.addUrlPatterns("/*");
    registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
    return registration;
  }


  /*public RestTemplate restTemplate(){

  }*/
}

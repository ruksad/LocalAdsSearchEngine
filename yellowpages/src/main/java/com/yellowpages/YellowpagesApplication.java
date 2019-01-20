package com.yellowpages;

import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class YellowpagesApplication {

	@Value("${yellowpages.rest.timezone}")
	private String timeZone;

	public static void main(String[] args) {
		SpringApplication.run(YellowpagesApplication.class, args);
	}

	public void setTimeZone(){
		TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
	}

}

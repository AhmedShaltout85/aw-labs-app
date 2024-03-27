package com.a08r.awlabsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.SpringServletContainerInitializer;


@SpringBootApplication
public class AwLabsAppApplication extends SpringServletContainerInitializer {


	public static void main(String[] args) {

		SpringApplication.run(AwLabsAppApplication.class, args);
	}

}

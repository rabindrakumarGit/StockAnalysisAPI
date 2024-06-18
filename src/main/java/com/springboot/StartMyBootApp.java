package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StartMyBootApp {

	public static void main(String []args) {
		// TODO Auto-generated method stub
		SpringApplication.run(StartMyBootApp.class, args);
		System.out.println("rabindra...");
	}

}

package com.hack.abes.userregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserRegistrationApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationApplication.class, args);
		
		
	}

}

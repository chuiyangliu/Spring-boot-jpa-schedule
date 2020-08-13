package com.zict.fourthde;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FourthdeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FourthdeApplication.class, args);
	}

}

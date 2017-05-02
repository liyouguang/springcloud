package com.lyg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ResourcesApplication {

		public static void main(String[] args) {
	        SpringApplication.run(ResourcesApplication.class, args);
	    }
	}

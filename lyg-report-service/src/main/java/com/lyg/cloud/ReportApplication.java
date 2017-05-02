/**
 * lyg-report-service
 * @author liyouguang.
 */
package com.lyg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ReportApplication {

		public static void main(String[] args) {
	        SpringApplication.run(ReportApplication.class, args);
	    }
	}

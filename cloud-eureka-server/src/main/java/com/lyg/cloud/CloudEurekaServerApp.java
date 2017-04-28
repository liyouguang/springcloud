/**
 * spring cloud eureka server
 * @author liyouguang 
 */
package com.lyg.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServerApp {
	public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServerApp.class, args);
    }
}

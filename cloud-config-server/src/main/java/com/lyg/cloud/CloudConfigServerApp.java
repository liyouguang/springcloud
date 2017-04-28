/**
 * spring cloud config server
 * @author liyouguang 
 */
package com.lyg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableConfigServer
public class CloudConfigServerApp {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigServerApp.class, args);
    }
}

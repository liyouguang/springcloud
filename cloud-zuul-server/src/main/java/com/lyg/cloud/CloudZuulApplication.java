package com.lyg.cloud;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.lyg.cloud.filter.AccessFilter;

/**
 * 
 * @author youguang.li
 *		@SpringCloudApplication 整合@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker  
 */
@EnableZuulProxy
@SpringCloudApplication
public class CloudZuulApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(CloudZuulApplication.class).web(true).run(args);
	}

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}

}

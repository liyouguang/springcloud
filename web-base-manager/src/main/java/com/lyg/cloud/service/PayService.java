/**
 * web-base-manager
 * @author liyouguang.
 */
package com.lyg.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PayService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        return restTemplate.getForEntity("http://GTA-PAY-SERVICE/payInfo/list", String.class).getBody();
    }

    public String addServiceFallback() {
        return "error";
    }

}

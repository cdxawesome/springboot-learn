package com.cdx.nacosdemoclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{value}")
    public String testEcho(@PathVariable String value){
        // 这是使用RestTemplate的方式，调用服务，一般我们用Feign比较方便
       return restTemplate.getForObject("http://nacos-demo/test/"+value,String.class);
    }
}

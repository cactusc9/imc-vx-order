package com.cactusc9.order.controller;

import com.cactusc9.order.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    ProductClient productClient;

    @GetMapping("/msg")
    public String getMsg(){
        // // 第一种方法：直接通过访问
        // RestTemplate restTemplate = new RestTemplate();
        // String result = restTemplate.getForObject("http://localhost:8080/server/msg", String.class);

        // 第二种方法：利用 loadBalancerClient 通过应用名取得 url ，然后同第一种方法
        // RestTemplate restTemplate = new RestTemplate();
        // ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        // String url = String.format("http://%s:%s/server/msg",serviceInstance.getHost(),serviceInstance.getPort());
        // String result = restTemplate.getForObject(url, String.class);

        // // 第三种方法：使用 @LoadBalanced 注解,可在 restTemplate 里直接使用应用名字  （通过ribbon依据某种规则，如简单轮循、随机连接去连接目标服务来实现负载均衡）
        // String result = restTemplate.getForObject("http://PRODUCT/server/msg", String.class);

        String result = productClient.getMsg();

        log.info("result = {}",result);
        return result;
    }

}

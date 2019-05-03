package com.cactusc9.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("PRODUCT")
public interface ProductClient {

    @GetMapping("/server/msg")
    String getMsg();
}

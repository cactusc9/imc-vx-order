package com.cactusc9.order.client;

import com.cactusc9.order.model.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("PRODUCT")
public interface ProductClient {

    @GetMapping("/server/msg")
    String getMsg();

    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(List<String> productIdList);
}

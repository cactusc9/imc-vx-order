package com.cactusc9.product.client;

import com.cactusc9.product.common.DecreaseStockInput;
import com.cactusc9.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("PRODUCT")
public interface ProductClient {

    /**
     * 获取商品信息列表(给订单服务调用)
     * @param productIdList 商品idList
     * @return
     */
    @PostMapping("product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    /**
     * 减库存(给订单服务调用)
     */
    @PostMapping("product/decreaseStock")
    String decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}

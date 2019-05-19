package com.cactusc9.product.service.impl;

import com.cactusc9.product.ProductApplicationTests;
import com.cactusc9.product.common.DecreaseStockInput;
import com.cactusc9.product.common.ProductInfoOutput;
import com.cactusc9.product.model.ProductInfo;
import com.cactusc9.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;


public class ProductServiceImplTest extends ProductApplicationTests {

    @Autowired
    ProductService productService;

    @Test
    public void findUp() {
        List<ProductInfo> productInfoList = productService.findUp();
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void findByProductIdIn() {
        List<ProductInfoOutput> productInfoList = productService.findByIdList(Arrays.asList("157875196366160022", "164103465734242707"));
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void decreaseStock(){
        DecreaseStockInput decreaseStockInput = new DecreaseStockInput("164103465734242707",3);
        productService.decreaseStock(Arrays.asList(decreaseStockInput));
    }
}
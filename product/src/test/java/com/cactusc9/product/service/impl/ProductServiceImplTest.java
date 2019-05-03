package com.cactusc9.product.service.impl;

import com.cactusc9.product.ProductApplicationTests;
import com.cactusc9.product.model.ProductInfo;
import com.cactusc9.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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
        List<ProductInfo> productInfoList = productService.findByIdList(Arrays.asList("157875196366160022", "164103465734242707"));
        Assert.assertTrue(productInfoList.size() > 0);
    }
}
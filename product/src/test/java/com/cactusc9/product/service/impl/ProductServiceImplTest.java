package com.cactusc9.product.service.impl;

import com.cactusc9.product.ProductApplicationTests;
import com.cactusc9.product.model.ProductInfo;
import com.cactusc9.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
}
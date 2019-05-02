package com.cactusc9.product.repository;

import com.cactusc9.product.ProductApplicationTests;
import com.cactusc9.product.model.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class ProductInfoRepositoryTest extends ProductApplicationTests {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Test
    public void testFindByProductStatus() {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(0);
        Assert.assertTrue(productInfoList.size() > 0);
    }

}
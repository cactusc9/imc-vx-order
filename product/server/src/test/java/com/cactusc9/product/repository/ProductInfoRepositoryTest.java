package com.cactusc9.product.repository;

import com.cactusc9.product.ProductApplicationTests;
import com.cactusc9.product.model.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;


public class ProductInfoRepositoryTest extends ProductApplicationTests {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Test
    public void testFindByProductStatus() {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(0);
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void findByProductIdIn() throws Exception {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductIdIn(Arrays.asList("157875196366160022", "164103465734242707"));
        Assert.assertTrue(productInfoList.size() > 0);
    }

}
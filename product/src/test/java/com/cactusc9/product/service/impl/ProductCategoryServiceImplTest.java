package com.cactusc9.product.service.impl;

import com.cactusc9.product.ProductApplicationTests;
import com.cactusc9.product.model.ProductCategory;
import com.cactusc9.product.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class ProductCategoryServiceImplTest extends ProductApplicationTests {

    @Autowired
    CategoryService productCategoryService;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(Arrays.asList(11, 12));
        Assert.assertTrue(productCategoryList.size() > 0);
    }
}
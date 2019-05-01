package com.cactusc9.product.repository;

import com.cactusc9.product.ProductApplicationTests;
import com.cactusc9.product.model.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ProductCategoryRepositoryTest extends ProductApplicationTests {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Test
    public void testFindByCategoryTypeIn(){
        List<ProductCategory> categoryList = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(12, 22));
        Assert.assertTrue(categoryList.size()==1);
    }

}
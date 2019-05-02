package com.cactusc9.product.service.impl;

import com.cactusc9.product.enums.ProductStatusEnum;
import com.cactusc9.product.model.ProductInfo;
import com.cactusc9.product.repository.ProductInfoRepository;
import com.cactusc9.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUp() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}

package com.cactusc9.product.service;

import com.cactusc9.product.common.DecreaseStockInput;
import com.cactusc9.product.common.ProductInfoOutput;
import com.cactusc9.product.model.ProductInfo;

import java.util.List;

public interface ProductService {

    List<ProductInfo> findUp();

    List<ProductInfoOutput> findByIdList(List<String> productIdList);

    void decreaseStock(List<DecreaseStockInput> productDTOList);
}

package com.cactusc9.product.service;

import com.cactusc9.product.dto.ProductDTO;
import com.cactusc9.product.model.ProductInfo;

import java.util.List;

public interface ProductService {

    List<ProductInfo> findUp();

    List<ProductInfo> findByIdList(List<String> productIdList);

    void decreaseStock(List<ProductDTO> productDTOList);
}

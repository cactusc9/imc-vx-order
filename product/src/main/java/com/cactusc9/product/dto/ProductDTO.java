package com.cactusc9.product.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private String productId;

    private Integer productQuantity;

    public ProductDTO() {
    }

    public ProductDTO(String productId, Integer productQuantity) {
        this.productQuantity = productQuantity;
        this.productId = productId;
    }
}

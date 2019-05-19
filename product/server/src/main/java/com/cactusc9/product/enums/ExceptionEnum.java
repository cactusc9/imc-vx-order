package com.cactusc9.product.enums;

import lombok.Getter;

@Getter
public enum ExceptionEnum {
    PRODUCT_NOT_EXIST(0,"商品不存在"),
    PRODUCT_STOCK_ERR(0,"商品库存不足"),
    ;

    private Integer code;

    private String message;

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

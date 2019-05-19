package com.cactusc9.product.exception;

import com.cactusc9.product.enums.ExceptionEnum;

public class ProductException extends RuntimeException {

    private Integer code;

    private String message;

    public ProductException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ProductException(ExceptionEnum exceptionEnum){
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }
}

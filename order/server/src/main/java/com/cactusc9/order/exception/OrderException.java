package com.cactusc9.order.exception;

import com.cactusc9.order.enums.ExceptionEnum;

public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }
}

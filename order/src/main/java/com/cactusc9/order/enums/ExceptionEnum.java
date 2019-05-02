package com.cactusc9.order.enums;

import lombok.Getter;

@Getter
public enum  ExceptionEnum {
    PARAM_ERR(1,"参数错误"),
    CAR_EMPTY_ERR(1,"购物车为空"),
    ;

    private Integer code;

    private String message;

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

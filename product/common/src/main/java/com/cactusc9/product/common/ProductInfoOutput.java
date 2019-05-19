package com.cactusc9.product.common;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductInfoOutput {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    /** 库存 */
    private Integer productStock;

    private String productDescription;

    private String productIcon;

    /** 状态，0:正常 1:下架 */
    private Integer productStatus;

    /** 类目编号*/
    private Integer categoryType;
}

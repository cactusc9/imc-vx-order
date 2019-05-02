package com.cactusc9.order.repository;

import com.cactusc9.order.OrderApplicationTests;
import com.cactusc9.order.enums.OrderStatusEnum;
import com.cactusc9.order.enums.PayStatusEnum;
import com.cactusc9.order.model.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Test
    public void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("12311");
        orderMaster.setOrderAmount(new BigDecimal(22.3));
        orderMaster.setBuyerAddress("玉林路");
        orderMaster.setBuyerName("许奕森");
        orderMaster.setBuyerOpenid("87987147320942837");
        orderMaster.setBuyerPhone("17611224455");
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null);
    }

}
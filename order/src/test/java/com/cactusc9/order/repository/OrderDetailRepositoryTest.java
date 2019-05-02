package com.cactusc9.order.repository;

import com.cactusc9.order.OrderApplicationTests;
import com.cactusc9.order.model.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    public void save() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1231221");
        orderDetail.setOrderId("12311");
        orderDetail.setProductIcon("http://wes.asdf");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal("1.11"));
        orderDetail.setProductQuantity(6);
        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertTrue(result != null);
    }

}
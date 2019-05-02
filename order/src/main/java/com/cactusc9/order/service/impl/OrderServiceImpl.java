package com.cactusc9.order.service.impl;

import com.cactusc9.order.DTO.OrderDTO;
import com.cactusc9.order.enums.OrderStatusEnum;
import com.cactusc9.order.enums.PayStatusEnum;
import com.cactusc9.order.model.OrderDetail;
import com.cactusc9.order.model.OrderMaster;
import com.cactusc9.order.repository.OrderDetailRepository;
import com.cactusc9.order.repository.OrderMasterRepository;
import com.cactusc9.order.service.OrderService;
import com.cactusc9.order.utils.UUIDUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;


    /**
     * . 参数校验
     * . 查询商品信息 (调用商品服务)
     * . 减少库存 (调用商品服务)
     * . 计算价格
     * . 创建订单
     */

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        // todo 查询商品信息(调用商品服务)
        // todo 减少库存(调用商品服务)
        // todo 计算价格

        // 创建订单
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(UUIDUtil.getUUID32());
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(new BigDecimal("12.33"));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        return orderDTO;
    }
}

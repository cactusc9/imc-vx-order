package com.cactusc9.order.service.impl;

import com.cactusc9.order.DTO.OrderDTO;
import com.cactusc9.product.client.ProductClient;
import com.cactusc9.order.enums.OrderStatusEnum;
import com.cactusc9.order.enums.PayStatusEnum;
import com.cactusc9.order.model.OrderDetail;
import com.cactusc9.order.model.OrderMaster;
import com.cactusc9.order.repository.OrderDetailRepository;
import com.cactusc9.order.repository.OrderMasterRepository;
import com.cactusc9.order.service.OrderService;
import com.cactusc9.order.utils.UUIDUtil;
import com.cactusc9.product.common.DecreaseStockInput;
import com.cactusc9.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    ProductClient productClient;


    /**
     * . 参数校验
     * . 查询商品信息 (调用商品服务)
     * . 减少库存 (调用商品服务)
     * . 计算价格
     * . 创建订单
     */

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = UUIDUtil.getUUID32();

        // 查询商品信息(调用商品服务)
        List<OrderDetail> orderDetailList = orderDTO.getOrderDetailList();
        List<String> productIdList = orderDetailList.stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfoOutput> productInfoOutputList = productClient.listForOrder(productIdList);

        // 计算价格
        BigDecimal amount = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDetailList) {
            for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
                if (Objects.equals(productInfoOutput.getProductId(), orderDetail.getProductId())) {
                    amount = productInfoOutput.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(amount);
                    BeanUtils.copyProperties(productInfoOutput, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(UUIDUtil.getUUID32());
                    // 订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }

        // 减少库存(调用商品服务)
        List<DecreaseStockInput> decreaseStockInputList = orderDetailList.stream()
                .map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(decreaseStockInputList);

        // 创建订单
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(amount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        return orderDTO;
    }
}

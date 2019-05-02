package com.cactusc9.order.converter;

import com.cactusc9.order.DTO.OrderDTO;
import com.cactusc9.order.enums.ExceptionEnum;
import com.cactusc9.order.exception.OrderException;
import com.cactusc9.order.form.OrderForm;
import com.cactusc9.order.model.OrderDetail;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList;

        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e) {
            log.error("【Json转换】错误，items = \"{}\"",orderForm.getItems());
            throw new OrderException(ExceptionEnum.PARAM_ERR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}

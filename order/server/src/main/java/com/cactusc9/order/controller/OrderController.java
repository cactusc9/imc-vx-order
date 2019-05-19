package com.cactusc9.order.controller;

import com.cactusc9.order.DTO.OrderDTO;
import com.cactusc9.order.VO.ResultVO;
import com.cactusc9.order.converter.OrderForm2OrderDTOConverter;
import com.cactusc9.order.enums.ExceptionEnum;
import com.cactusc9.order.exception.OrderException;
import com.cactusc9.order.form.OrderForm;
import com.cactusc9.order.service.OrderService;
import com.cactusc9.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public ResultVO create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数错误,items={}",bindingResult.getFieldError().getDefaultMessage());
            throw new OrderException(ExceptionEnum.PARAM_ERR);
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车为空");
            throw new OrderException(ExceptionEnum.PARAM_ERR);
        }
        orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",orderDTO.getOrderId());
        return ResultVOUtil.succeed(map);


    }
}

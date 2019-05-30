package com.cactusc9.order.controller;

import com.cactusc9.order.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/girl")
public class GirlController {

    @Autowired
    GirlConfig girlConfig;

    @RequestMapping("/print")
    public String print() {
        return girlConfig.toString();

    }
}

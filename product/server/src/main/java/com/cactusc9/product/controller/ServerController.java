package com.cactusc9.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/server")
public class ServerController {

    @GetMapping("/msg")
    public String getMsg(HttpServletRequest request){
        return "this is product server! port:"+request.getLocalPort();
    }

}

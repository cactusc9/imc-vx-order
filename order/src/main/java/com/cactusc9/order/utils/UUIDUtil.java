package com.cactusc9.order.utils;

import java.util.UUID;

public class UUIDUtil {

    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-","");
    }
}

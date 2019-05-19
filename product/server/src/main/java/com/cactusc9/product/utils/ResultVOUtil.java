package com.cactusc9.product.utils;

import com.cactusc9.product.VO.ResultVO;


public class ResultVOUtil {

    public static ResultVO succeed(Object data){
        ResultVO resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMessage("获取成功");
        resultVO.setData(data);
        return resultVO;
    }
}

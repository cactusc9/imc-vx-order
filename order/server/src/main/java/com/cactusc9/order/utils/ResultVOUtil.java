package com.cactusc9.order.utils;


import com.cactusc9.order.VO.ResultVO;

public class ResultVOUtil {

    public static ResultVO succeed(Object data){
        ResultVO resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        resultVO.setData(data);
        return resultVO;
    }
}

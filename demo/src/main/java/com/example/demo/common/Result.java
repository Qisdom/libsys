package com.example.demo.common;

import lombok.Data;

@Data
public class Result {

    private String code;    //状态代码
    private Object data;    //数据
    private String msg;     //错误信息

    private static final String SUCCESS_CODE="200";
    private static final String ERROR_CODE="-1";

    public static Result success() {
        Result result=new Result();
        result.setCode(SUCCESS_CODE);
        return  result;
    }
    public static Result success(Object data) {
        Result result=new Result();
        result.setData(data);
        result.setCode(SUCCESS_CODE);
        return  result;
    }
    public static Result error(String msg) {
        Result result=new Result();
        result.setCode(ERROR_CODE);
        result.setMsg(msg);
        return  result;
    }
}

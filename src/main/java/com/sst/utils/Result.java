package com.sst.utils;

import static com.sst.utils.Code.*;

public class Result {
    Integer code;
    String msg;
    Object data;

    //success
    public static Result success(){
        return new Result(SUCCESS.code,SUCCESS.msg);
    }
    public static Result success(Object data){
        return new Result(SUCCESS.code,SUCCESS.msg,data);
    }
    //fail
    public static Result error(){
        return new Result(ERROR.code,ERROR.msg);
    }
    public static Result error(String msg){
        return new Result(ERROR.code,msg);
    }
    public static Result noData(){
        return new Result(NODATA.code,NODATA.msg);
    }
    public static Result loginError(){
        return new Result(LOGIN_ERROR.code,LOGIN_ERROR.msg);
    }
    public static Result notEmpty(){
        return new Result(NOT_EMPTY.code,NOT_EMPTY.msg);
    }



    public Result(Object data) {
        this.data = data;
    }
    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

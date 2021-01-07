package com.sst.framework.mvc;

import com.sst.framework.exception.MyException;
import com.sst.utils.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result handle(RuntimeException e){
        e.printStackTrace();
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result handle(MyException e){
        e.printStackTrace();
        return Result.error(e.getMessage());
    }

}

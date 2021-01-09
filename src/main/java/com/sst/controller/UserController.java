package com.sst.controller;

import com.github.pagehelper.PageInfo;
import com.sst.entity.User;
import com.sst.service.UserService;
import com.sst.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("create")
    public Result create(@RequestBody User user){
        user.setCreateDate(new Date());
        int flag = userService.create(user);
        if(flag>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @PostMapping("query")
    public Result query (@RequestBody User user){
        System.out.println(user==null);
        PageInfo<User> userPageInfo = userService.queryByPage(user);
        return Result.success(userPageInfo);

    }
    @PostMapping("delete")
    public Result delete(Integer id){
        int delete = userService.delete(id);
        if (delete>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @PostMapping("update")
    public Result update(@RequestBody User user){
        int flag = userService.updateSelective(user);
        if(flag>0){
            return Result.success(user);
        }else{
            return Result.error();
        }
    }
}

package com.sst.controller;

import com.github.pagehelper.PageInfo;
import com.sst.entity.User;
import com.sst.service.UserService;
import com.sst.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("create")
    public String create( User user){
        System.out.println(user.getNickName());
        System.out.println(user.getUserName());
        userService.create(user);
        return "haha";
    }
    @PostMapping("query")
    public Result query (@RequestBody User user){
        System.out.println(user==null);
        PageInfo<User> userPageInfo = userService.queryByPage(user);
        return Result.success(userPageInfo);

    }
}

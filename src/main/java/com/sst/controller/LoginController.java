package com.sst.controller;

import com.sst.entity.User;
import com.sst.framework.jwt.JWTUtils;
import com.sst.service.UserService;
import com.sst.utils.MapControl;
import com.sst.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource
    private UserService userService;

    @PostMapping("login")
    public Result login(@RequestBody User user){

        User queryUser = userService.login(user);
        System.out.println(queryUser);
        if (queryUser != null){
            String token = JWTUtils.sign(queryUser);
            return Result.success(MapControl.getInstance().add("token",token).add("user",queryUser).getMap());
        }else {
            return Result.error("用户名或密码错误");
        }

    }
}

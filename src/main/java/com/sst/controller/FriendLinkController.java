package com.sst.controller;

import com.github.pagehelper.PageInfo;
import com.sst.entity.Comment;
import com.sst.entity.FriendLink;
import com.sst.service.FriendLinkService;
import com.sst.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("friendLink")
public class FriendLinkController {
    @Resource
    private FriendLinkService friendLinkService;

    @RequestMapping("create")
    public Result create(@RequestBody FriendLink friendLink){
        int flag = friendLinkService.create(friendLink);
        if(flag>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @PostMapping("query")
    public Result query (@RequestBody FriendLink friendLink){
        System.out.println(friendLink==null);
        PageInfo<FriendLink> friendLinkPageInfo = friendLinkService.queryByPage(friendLink);
        return Result.success(friendLinkPageInfo);

    }
    @PostMapping("delete")
    public Result delete(Integer id){
        int delete = friendLinkService.delete(id);
        if (delete>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @PostMapping("update")
    public Result update(@RequestBody FriendLink friendLink){
        int flag = friendLinkService.updateSelective(friendLink);
        if(flag>0){
            return Result.success(friendLink);
        }else{
            return Result.error();
        }
    }
    @PostMapping("detail")
    public Result detail(Integer id){
        FriendLink detail = friendLinkService.detail(id);
        if (detail != null){
            return Result.success(detail);
        }else{
            return Result.error();
        }
    }
}

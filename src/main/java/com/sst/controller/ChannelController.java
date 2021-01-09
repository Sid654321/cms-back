package com.sst.controller;

import com.github.pagehelper.PageInfo;
import com.sst.entity. Channel;
import com.sst.service. ChannelService;
import com.sst.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping(" channel")
public class ChannelController {
    @Resource
    private  ChannelService  channelService;

    @RequestMapping("create")
    public Result create(@RequestBody  Channel  channel){
        int flag =  channelService.create( channel);
        if(flag>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @PostMapping("query")
    public Result query (@RequestBody  Channel  channel){
        System.out.println( channel==null);
        PageInfo< Channel>  channelPageInfo =  channelService.queryByPage( channel);
        return Result.success( channelPageInfo);

    }
    @PostMapping("delete")
    public Result delete(Integer id){
        int delete =  channelService.delete(id);
        if (delete>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @PostMapping("update")
    public Result update(@RequestBody  Channel  channel){
        int flag =  channelService.updateSelective( channel);
        if(flag>0){
            return Result.success( channel);
        }else{
            return Result.error();
        }
    }
}

package com.sst.controller;

import com.github.pagehelper.PageInfo;
import com.sst.entity.Tag;
import com.sst.service.TagService;
import com.sst.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("tag")
public class TagController {
    @Resource
    private TagService tagService;

    @RequestMapping("create")
    public Result create(@RequestBody Tag tag){
        int flag = tagService.create(tag);
        if(flag>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @PostMapping("query")
    public Result query (@RequestBody Tag tag){
        System.out.println(tag==null);
        PageInfo<Tag> tagPageInfo = tagService.queryByPage(tag);
        return Result.success(tagPageInfo);

    }
    @PostMapping("delete")
    public Result delete(Integer id){
        int delete = tagService.delete(id);
        if (delete>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @PostMapping("update")
    public Result update(@RequestBody Tag tag){
        int flag = tagService.updateSelective(tag);
        if(flag>0){
            return Result.success(tag);
        }else{
            return Result.error();
        }
    }
}

package com.sst.controller;

import com.github.pagehelper.PageInfo;
import com.sst.entity.ArticleTag;
import com.sst.service.ArticleTagService;
import com.sst.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("articleTag")
public class ArticleTagController {
    @Resource
    private ArticleTagService articleTagService;

    @RequestMapping("create")
    public Result create(@RequestBody ArticleTag articleTag){
        int flag = articleTagService.create(articleTag);
        if(flag>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @PostMapping("query")
    public Result query (@RequestBody ArticleTag articleTag){
        System.out.println(articleTag==null);
        PageInfo<ArticleTag> articleTagPageInfo = articleTagService.queryByPage(articleTag);
        return Result.success(articleTagPageInfo);

    }
    @PostMapping("delete")
    public Result delete(Integer id){
        int delete = articleTagService.delete(id);
        if (delete>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @PostMapping("update")
    public Result update(@RequestBody ArticleTag articleTag){
        int flag = articleTagService.updateSelective(articleTag);
        if(flag>0){
            return Result.success(articleTag);
        }else{
            return Result.error();
        }
    }
}

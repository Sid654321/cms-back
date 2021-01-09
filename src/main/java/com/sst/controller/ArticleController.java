package com.sst.controller;

import com.github.pagehelper.PageInfo;
import com.sst.entity.Article;
import com.sst.service.ArticleService;
import com.sst.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @RequestMapping("create")
    public Result create(@RequestBody Article article){
        int flag = articleService.create(article);
        if(flag>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @PostMapping("query")
    public Result query (@RequestBody Article article){
        System.out.println(article==null);
        PageInfo<Article> articlePageInfo = articleService.queryByPage(article);
        return Result.success(articlePageInfo);

    }
    @PostMapping("delete")
    public Result delete(Integer id){
        int delete = articleService.delete(id);
        if (delete>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @PostMapping("update")
    public Result update(@RequestBody Article article){
        int flag = articleService.updateSelective(article);
        if(flag>0){
            return Result.success(article);
        }else{
            return Result.error();
        }
    }
}

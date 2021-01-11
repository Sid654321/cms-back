package com.sst.controller;

import com.github.pagehelper.PageInfo;
import com.sst.entity.Article;
import com.sst.entity.ArticleView;
import com.sst.service.ArticleViewService;
import com.sst.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("articleView")
public class ArticleViewController {
    @Resource
    private ArticleViewService articleViewService;

    @RequestMapping("create")
    public Result create(@RequestBody ArticleView articleView){
        int flag = articleViewService.create(articleView);
        if(flag>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @PostMapping("query")
    public Result query (@RequestBody ArticleView articleView){
        System.out.println(articleView==null);
        PageInfo<ArticleView> articleViewPageInfo = articleViewService.queryByPage(articleView);
        return Result.success(articleViewPageInfo);

    }
    @PostMapping("delete")
    public Result delete(Integer id){
        int delete = articleViewService.delete(id);
        if (delete>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @PostMapping("detail")
    public Result detail(Integer id){
        ArticleView detail = articleViewService.detail(id);
        if (detail != null){
            return Result.success(detail);
        }else{
            return Result.error();
        }
    }
    @PostMapping("update")
    public Result update(@RequestBody ArticleView articleView){
        int flag = articleViewService.updateSelective(articleView);
        if(flag>0){
            return Result.success(articleView);
        }else{
            return Result.error();
        }
    }
}

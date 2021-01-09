package com.sst.controller;

import com.github.pagehelper.PageInfo;
import com.sst.entity.ArticleAttachment;
import com.sst.service.ArticleAttachmentService;
import com.sst.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("articleAttachment")
public class ArticleAttachmentController {
    @Resource
    private ArticleAttachmentService articleAttachmentService;

    @RequestMapping("create")
    public Result create(@RequestBody ArticleAttachment articleAttachment){
        int flag = articleAttachmentService.create(articleAttachment);
        if(flag>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @PostMapping("query")
    public Result query (@RequestBody ArticleAttachment articleAttachment){
        System.out.println(articleAttachment==null);
        PageInfo<ArticleAttachment> articleAttachmentPageInfo = articleAttachmentService.queryByPage(articleAttachment);
        return Result.success(articleAttachmentPageInfo);

    }
    @PostMapping("delete")
    public Result delete(Integer id){
        int delete = articleAttachmentService.delete(id);
        if (delete>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @PostMapping("update")
    public Result update(@RequestBody ArticleAttachment articleAttachment){
        int flag = articleAttachmentService.updateSelective(articleAttachment);
        if(flag>0){
            return Result.success(articleAttachment);
        }else{
            return Result.error();
        }
    }
}

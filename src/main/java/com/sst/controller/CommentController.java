package com.sst.controller;

import com.github.pagehelper.PageInfo;
import com.sst.entity.ArticleView;
import com.sst.entity.Comment;
import com.sst.service.CommentService;
import com.sst.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    @RequestMapping("create")
    public Result create(@RequestBody Comment comment){
        int flag = commentService.create(comment);
        if(flag>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @PostMapping("query")
    public Result query (@RequestBody Comment comment){
        System.out.println(comment==null);
        PageInfo<Comment> commentPageInfo = commentService.queryByPage(comment);
        return Result.success(commentPageInfo);

    }
    @PostMapping("delete")
    public Result delete(Integer id){
        int delete = commentService.delete(id);
        if (delete>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @PostMapping("update")
    public Result update(@RequestBody Comment comment){
        int flag = commentService.updateSelective(comment);
        if(flag>0){
            return Result.success(comment);
        }else{
            return Result.error();
        }
    }

    @PostMapping("detail")
    public Result detail(Integer id){
        Comment detail = commentService.detail(id);
        if (detail != null){
            return Result.success(detail);
        }else{
            return Result.error();
        }
    }
}

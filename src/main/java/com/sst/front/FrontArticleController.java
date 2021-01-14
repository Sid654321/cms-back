package com.sst.front;

import com.github.pagehelper.PageInfo;
import com.sst.entity.Article;
import com.sst.service.ArticleService;
import com.sst.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/f/article")
public class FrontArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 查询单个文章
     * @param id
     * @return
     */
    @GetMapping("/get")
    public Result getById(Integer id){
        Article detail = articleService.detail(id);
        return Result.success(detail);
    }

    /**
     *  按照栏目ID查询文章列表
     * @param article
     * @return
     */
    @GetMapping("/getList")
    public Result getByChannelId(Article article){
        PageInfo<Article> page = articleService.queryByPage(article);
        return Result.success(page);
    }

    /**
     * 获取前几条数据
     * @param article
     * @param top 前几条
     * @return
     */
    @GetMapping("/getTop")
    public Result getById(Article article,Integer top){
        List<Article> list = articleService.top(article, top);
        return Result.success(list);
    }

    /**
     * 获取置顶最新数据
     * @return
     */
    @GetMapping("/getUp")
    public Result getUp(){
        Article article = new Article();
        article.setTop(1);
        PageInfo<Article> page = articleService.queryByPage(article);
        return Result.success(page);
    }

}


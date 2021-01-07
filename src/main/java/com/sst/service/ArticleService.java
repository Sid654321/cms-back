package com.sst.service;

import com.sst.mapper.ArticleMapper;
import com.sst.entity.Article;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    public int create(Article article) {
        return articleMapper.create(article);
    }

    public int delete(Integer id) {
        return articleMapper.delete(id);
    }

    public int update(Article article) {
        return articleMapper.update(article);
    }

    public int updateSelective(Article article) {
        return articleMapper.updateSelective(article);
    }

    public List<Article> query(Article article) {
        return articleMapper.query(article);
    }

    public Article detail(Integer id) {
        return articleMapper.detail(id);
    }

    public int count(Article article) {
        return articleMapper.count(article);
    }
}

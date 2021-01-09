package com.sst.service;

import com.github.pagehelper.PageInfo;
import com.sst.entity.Article;
import com.sst.mapper.ArticleMapper;
import com.sst.entity.Article;
import javax.annotation.Resource;

import com.sst.utils.PageHelperUtils;
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

    public PageInfo<Article> queryByPage(Article article) {
        PageHelperUtils.pageHelper(article);
        List<Article> query = articleMapper.query(article);
        return new PageInfo<Article>(query);
    }
}

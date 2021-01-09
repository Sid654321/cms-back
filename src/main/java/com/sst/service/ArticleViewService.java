package com.sst.service;

import com.github.pagehelper.PageInfo;
import com.sst.entity.ArticleView;
import com.sst.mapper.ArticleViewMapper;
import com.sst.entity.ArticleView;
import javax.annotation.Resource;

import com.sst.utils.PageHelperUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleViewService {

    @Resource
    private ArticleViewMapper articleViewMapper;

    public int create(ArticleView articleView) {
        return articleViewMapper.create(articleView);
    }

    public int delete(Integer id) {
        return articleViewMapper.delete(id);
    }

    public int update(ArticleView articleView) {
        return articleViewMapper.update(articleView);
    }

    public int updateSelective(ArticleView articleView) {
        return articleViewMapper.updateSelective(articleView);
    }

    public List<ArticleView> query(ArticleView articleView) {
        return articleViewMapper.query(articleView);
    }

    public ArticleView detail(Integer id) {
        return articleViewMapper.detail(id);
    }

    public int count(ArticleView articleView) {
        return articleViewMapper.count(articleView);
    }

    public PageInfo<ArticleView> queryByPage(ArticleView articleView) {
        PageHelperUtils.pageHelper(articleView);
        List<ArticleView> query = articleViewMapper.query(articleView);
        return new PageInfo<ArticleView>(query);
    }
}

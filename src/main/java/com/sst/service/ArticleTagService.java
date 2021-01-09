package com.sst.service;

import com.github.pagehelper.PageInfo;
import com.sst.entity.ArticleTag;
import com.sst.mapper.ArticleTagMapper;
import com.sst.entity.ArticleTag;
import javax.annotation.Resource;

import com.sst.utils.PageHelperUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleTagService {

    @Resource
    private ArticleTagMapper articleTagMapper;

    public int create(ArticleTag articleTag) {
        return articleTagMapper.create(articleTag);
    }

    public int delete(Integer id) {
        return articleTagMapper.delete(id);
    }

    public int update(ArticleTag articleTag) {
        return articleTagMapper.update(articleTag);
    }

    public int updateSelective(ArticleTag articleTag) {
        return articleTagMapper.updateSelective(articleTag);
    }

    public List<ArticleTag> query(ArticleTag articleTag) {
        return articleTagMapper.query(articleTag);
    }

    public ArticleTag detail(Integer id) {
        return articleTagMapper.detail(id);
    }

    public int count(ArticleTag articleTag) {
        return articleTagMapper.count(articleTag);
    }

    public PageInfo<ArticleTag> queryByPage(ArticleTag articleTag) {
        PageHelperUtils.pageHelper(articleTag);
        List<ArticleTag> query = articleTagMapper.query(articleTag);
        return new PageInfo<ArticleTag>(query);
    }
}

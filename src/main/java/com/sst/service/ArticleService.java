package com.sst.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sst.entity.Article;
import com.sst.entity.ArticleAttachment;
import com.sst.entity.ArticleTag;
import com.sst.mapper.ArticleAttachmentMapper;
import com.sst.mapper.ArticleMapper;
import com.sst.entity.Article;
import javax.annotation.Resource;

import com.sst.mapper.ArticleTagMapper;

import com.sst.utils.PageHelperUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleAttachmentMapper articleAttachmentMapper;
    @Resource
    private ArticleTagMapper articleTagMapper;

    @Transactional
    public int create(Article article) {
        int flag = articleMapper.create(article);
        List<Map<String, String>> attachmentList = article.getAttachmentList();
        attachmentList.forEach(attachment->{
            ArticleAttachment newAttachment = new ArticleAttachment();
            newAttachment.setArticleId(article.getId());
            newAttachment.setDescription(attachment.get("name"));
            newAttachment.setUrl(attachment.get("url"));
            articleAttachmentMapper.create(newAttachment);
        });
        List<Integer> tagList = article.getTagList();
        tagList.forEach(tagId->{
            ArticleTag articleTag = new ArticleTag();
            articleTag.setArticleId(article.getId());
            articleTag.setTagId(tagId);
            articleTagMapper.create(articleTag);
        });
        return flag;
    }

    public int delete(Integer id) {
        return articleMapper.delete(id);
    }

    public int update(Article article) {
        return articleMapper.update(article);
    }

    public int updateSelective(Article article) {
        int flag = articleMapper.updateSelective(article);
        List<Map<String, String>> attachmentList = article.getAttachmentList();
        attachmentList.forEach(attachment->{
            ArticleAttachment newAttachment = new ArticleAttachment();
            newAttachment.setArticleId(article.getId());
            newAttachment.setDescription(attachment.get("name"));
            newAttachment.setUrl(attachment.get("url"));
            articleAttachmentMapper.create(newAttachment);
        });
        List<Integer> tagList = article.getTagList();
        tagList.forEach(tagId->{
            ArticleTag articleTag = new ArticleTag();
            articleTag.setArticleId(article.getId());
            articleTag.setTagId(tagId);
            articleTagMapper.create(articleTag);
        });
        return flag;
    }

    public List<Article> query(Article article) {
        return articleMapper.query(article);
    }

    public Article detail(Integer id) {
        Article article = articleMapper.detail(id);
        //查询文章评论
        ArticleAttachment articleAttachment = new ArticleAttachment();
        articleAttachment.setArticleId(article.getId());
        List<ArticleAttachment> articleAttachmentQuery = articleAttachmentMapper.query(articleAttachment);
        List<Map<String,String>> articleAttachmentList = new ArrayList<>();
        articleAttachmentQuery.forEach(articleAttachment1 -> {
            Map<String,String> map = new HashMap<>();
            map.put("name",articleAttachment1.getDescription());
            map.put("url",articleAttachment1.getUrl());
            articleAttachmentList.add(map);
        });
        article.setAttachmentList(articleAttachmentList);
        //查询文章标签
        ArticleTag articleTag = new ArticleTag();
        articleTag.setArticleId(article.getId());
        List<ArticleTag> articleTagList = articleTagMapper.query(articleTag);
        List<Integer>  articleTagIdList = new ArrayList();
        articleTagList.forEach(articleTag1 -> {
            articleTagIdList.add(articleTag1.getTagId());
        });
        article.setTagList(articleTagIdList);

        return article;
    }

    public int count(Article article) {
        return articleMapper.count(article);
    }

    public PageInfo<Article> queryByPage(Article article) {
        PageHelperUtils.pageHelper(article);
        List<Article> query = articleMapper.query(article);
        return new PageInfo<Article>(query);
    }

    public List<Article> top(Article article, Integer top) {
        PageHelper.startPage(0,top);
        return articleMapper.query(article);
    }
}

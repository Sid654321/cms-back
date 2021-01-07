package com.sst.mapper;

import java.util.List;
import java.util.Map;

import com.sst.entity.Article;

public interface ArticleMapper {

	public int create(Article article);

	public int delete(Integer id);

	public int update(Article article);

	public int updateSelective(Article article);

	public List<Article> query(Article article);


	public Article detail(Integer id);

	public int count(Article article);

}
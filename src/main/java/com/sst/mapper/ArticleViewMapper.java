package com.sst.mapper;

import java.util.List;
import java.util.Map;

import com.sst.entity.ArticleView;

public interface ArticleViewMapper {

	public int create(ArticleView articleView);

	public int delete(Integer id);

	public int update(ArticleView articleView);

	public int updateSelective(ArticleView articleView);

	public List<ArticleView> query(ArticleView articleView);


	public ArticleView detail(Integer id);

	public int count(ArticleView articleView);

}
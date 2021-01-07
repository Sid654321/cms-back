package com.sst.mapper;

import java.util.List;
import java.util.Map;

import com.sst.entity.ArticleTag;

public interface ArticleTagMapper {

	public int create(ArticleTag articleTag);

	public int delete(Integer id);

	public int update(ArticleTag articleTag);

	public int updateSelective(ArticleTag articleTag);

	public List<ArticleTag> query(ArticleTag articleTag);


	public ArticleTag detail(Integer id);

	public int count(ArticleTag articleTag);

}
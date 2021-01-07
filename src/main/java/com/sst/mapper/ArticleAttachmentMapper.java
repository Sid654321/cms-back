package com.sst.mapper;

import java.util.List;
import java.util.Map;

import com.sst.entity.ArticleAttachment;

public interface ArticleAttachmentMapper {

	public int create(ArticleAttachment articleAttachment);

	public int delete(Integer id);

	public int update(ArticleAttachment articleAttachment);

	public int updateSelective(ArticleAttachment articleAttachment);

	public List<ArticleAttachment> query(ArticleAttachment articleAttachment);


	public ArticleAttachment detail(Integer id);

	public int count(ArticleAttachment articleAttachment);

}
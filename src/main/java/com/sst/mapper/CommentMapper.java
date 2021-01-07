package com.sst.mapper;

import java.util.List;
import java.util.Map;

import com.sst.entity.Comment;

public interface CommentMapper {

	public int create(Comment comment);

	public int delete(Integer id);

	public int update(Comment comment);

	public int updateSelective(Comment comment);

	public List<Comment> query(Comment comment);


	public Comment detail(Integer id);

	public int count(Comment comment);

}
package com.sst.mapper;

import java.util.List;
import java.util.Map;

import com.sst.entity.Tag;

public interface TagMapper {

	public int create(Tag tag);

	public int delete(Integer id);

	public int update(Tag tag);

	public int updateSelective(Tag tag);

	public List<Tag> query(Tag tag);


	public Tag detail(Integer id);

	public int count(Tag tag);

}
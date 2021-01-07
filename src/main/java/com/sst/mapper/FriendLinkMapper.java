package com.sst.mapper;

import java.util.List;
import java.util.Map;

import com.sst.entity.FriendLink;

public interface FriendLinkMapper {

	public int create(FriendLink friendLink);

	public int delete(Integer id);

	public int update(FriendLink friendLink);

	public int updateSelective(FriendLink friendLink);

	public List<FriendLink> query(FriendLink friendLink);


	public FriendLink detail(Integer id);

	public int count(FriendLink friendLink);

}
package com.sst.mapper;

import java.util.List;


import com.sst.entity.User;

public interface UserMapper {

	public int create(User user);

	public int delete(Integer id);

	public int update(User user);

	public int updateSelective(User user);

	public List<User> query(User user);

	public User login(User user);


	public User detail(Integer id);

	public int count(User user);

}
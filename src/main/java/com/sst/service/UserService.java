package com.sst.service;

import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;

import com.sst.entity.User;
import com.sst.mapper.UserMapper;
import com.sst.utils.PageHelperUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public int create(User user) {
        return userMapper.create(user);
    }

    public int delete(Integer id) {
        return userMapper.delete(id);
    }

    public int update(User user) {
        return userMapper.update(user);
    }

    public int updateSelective(User user) {
        return userMapper.updateSelective(user);
    }

    public List<User> query(User user) {
        return userMapper.query(user);
    }

    public User login(User user) {
        return userMapper.login(user);
    }
    public PageInfo<User> queryByPage(User user) {
        PageHelperUtils.pageHelper(user);
        List<User> query = userMapper.query(user);
        return new PageInfo<User>(query);
    }

    public User detail(Integer id) {
        return userMapper.detail(id);
    }

    public int count(User user) {
        return userMapper.count(user);
    }
}

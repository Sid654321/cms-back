package com.sst.service;

import com.github.pagehelper.PageInfo;
import com.sst.entity.FriendLink;
import com.sst.mapper.FriendLinkMapper;
import com.sst.entity.FriendLink;
import javax.annotation.Resource;

import com.sst.utils.PageHelperUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FriendLinkService {

    @Resource
    private FriendLinkMapper friendLinkMapper;

    public int create(FriendLink friendLink) {
        return friendLinkMapper.create(friendLink);
    }

    public int delete(Integer id) {
        return friendLinkMapper.delete(id);
    }

    public int update(FriendLink friendLink) {
        return friendLinkMapper.update(friendLink);
    }

    public int updateSelective(FriendLink friendLink) {
        return friendLinkMapper.updateSelective(friendLink);
    }

    public List<FriendLink> query(FriendLink friendLink) {
        return friendLinkMapper.query(friendLink);
    }

    public FriendLink detail(Integer id) {
        return friendLinkMapper.detail(id);
    }

    public int count(FriendLink friendLink) {
        return friendLinkMapper.count(friendLink);
    }

    public PageInfo<FriendLink> queryByPage(FriendLink friendLink) {
        PageHelperUtils.pageHelper(friendLink);
        List<FriendLink> query = friendLinkMapper.query(friendLink);
        return new PageInfo<FriendLink>(query);
    }
}

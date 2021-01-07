package com.sst.service;

import com.sst.mapper.ChannelMapper;
import com.sst.entity.Channel;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChannelService {

    @Resource
    private ChannelMapper channelMapper;

    public int create(Channel channel) {
        return channelMapper.create(channel);
    }

    public int delete(Integer id) {
        return channelMapper.delete(id);
    }

    public int update(Channel channel) {
        return channelMapper.update(channel);
    }

    public int updateSelective(Channel channel) {
        return channelMapper.updateSelective(channel);
    }

    public List<Channel> query(Channel channel) {
        return channelMapper.query(channel);
    }

    public Channel detail(Integer id) {
        return channelMapper.detail(id);
    }

    public int count(Channel channel) {
        return channelMapper.count(channel);
    }
}

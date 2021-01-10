package com.sst.service;

import com.github.pagehelper.PageInfo;
import com.sst.entity.Channel;
import com.sst.mapper.ChannelMapper;
import com.sst.entity.Channel;
import javax.annotation.Resource;

import com.sst.utils.PageHelperUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public PageInfo<Channel> queryByPage(Channel channel) {
        PageHelperUtils.pageHelper(channel);
        List<Channel> query = channelMapper.query(channel);
        return new PageInfo<Channel>(query);
    }

    public List<Map<String,Object>> tree(){
        List<Map<String, Object>> mapList = new ArrayList<>();
        List<Channel> channels = channelMapper.query(null);
        for (Channel channel:channels) {
            if (channel.getParentId() == 0){
                Map<String, Object> mapFirst = new HashMap<>();
                mapFirst.put("id",channel.getId());
                mapFirst.put("label",channel.getName());
                List<Map<String, Object>> childrenFirst = new ArrayList<>();
                for (Channel channel2:channels) {
                    if(channel2.getParentId() == channel.getId()){
                        Map<String, Object> mapSecond = new HashMap<>();
                        mapSecond.put("id",channel2.getId());
                        mapSecond.put("label",channel2.getName());
                        childrenFirst.add(mapSecond);
                    }
                }
                mapFirst.put("children",childrenFirst);
                mapList.add(mapFirst);
            }
        }

        return mapList;
    }
}

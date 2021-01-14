package com.sst.front;


import com.sst.entity.Channel;
import com.sst.service.ChannelService;
import com.sst.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/f/channel")
public class FrontChannelController {
    @Resource
    private ChannelService channelService;

    @GetMapping("get")
    public Result get (Integer id){
        if(id == null){
            return Result.error();
        }
        Channel detail = channelService.detail(id);
        if (detail != null){
            return Result.success(detail);
        }else {
            return Result.error();
        }
    }

    @GetMapping("/queryByPos")
    public Result getChannelByPos(String pos){
        if(pos == null || pos.length() == 0){
            return Result.error();
        }
        List<Channel> channels = channelService.getChannelByPos(pos.toUpperCase());
        List<Map<String,Object>> mapList = new ArrayList<>();

        for (Channel channel : channels) {
            //首先获取顶级栏目（递归）
            if(channel.getParentId() == 0){
                Map<String,Object> map = new HashMap<>();
                map.put("id",channel.getId());
                map.put("name",channel.getName());
                if(channel.getSingle() != null && "Y".equals(channel.getSingle())){
                    map.put("single",true);
                }
                List<Map<String,Object>> children = new ArrayList<>();
                for (Channel entity : channels) {
                    if(entity.getParentId() == channel.getId()){
                        Map<String,Object> subMap = new HashMap<>();
                        subMap.put("id",entity.getId());
                        subMap.put("name",entity.getName());
                        if(entity.getSingle() != null && "Y".equals(entity.getSingle())){
                            subMap.put("single",true);
                        }
                        children.add(subMap);
                    }
                }
                if(children.size()>0){
                    map.put("children",children);
                }
                mapList.add(map);
            }
        }
        return Result.success(mapList);
    }

}

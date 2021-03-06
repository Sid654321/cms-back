package com.sst.service;

import com.github.pagehelper.PageInfo;
import com.sst.entity.Tag;
import com.sst.mapper.TagMapper;
import javax.annotation.Resource;

import com.sst.utils.PageHelperUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TagService {

    @Resource
    private TagMapper tagMapper;

    public int create(Tag tag) {
        return tagMapper.create(tag);
    }

    public int delete(Integer id) {
        return tagMapper.delete(id);
    }

    public int update(Tag tag) {
        return tagMapper.update(tag);
    }

    public int updateSelective(Tag tag) {
        return tagMapper.updateSelective(tag);
    }

    public List<Tag> query(Tag tag) {
        return tagMapper.query(tag);
    }

    public Tag detail(Integer id) {
        return tagMapper.detail(id);
    }

    public int count(Tag tag) {
        return tagMapper.count(tag);
    }

    public PageInfo<Tag> queryByPage(Tag tag) {
        PageHelperUtils.pageHelper(tag);
        List<Tag> query = tagMapper.query(tag);
        return new PageInfo<Tag>(query);
    }
}

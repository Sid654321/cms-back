package com.sst.service;

import com.sst.mapper.CommentMapper;
import com.sst.entity.Comment;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {

    @Resource
    private CommentMapper commentMapper;

    public int create(Comment comment) {
        return commentMapper.create(comment);
    }

    public int delete(Integer id) {
        return commentMapper.delete(id);
    }

    public int update(Comment comment) {
        return commentMapper.update(comment);
    }

    public int updateSelective(Comment comment) {
        return commentMapper.updateSelective(comment);
    }

    public List<Comment> query(Comment comment) {
        return commentMapper.query(comment);
    }

    public Comment detail(Integer id) {
        return commentMapper.detail(id);
    }

    public int count(Comment comment) {
        return commentMapper.count(comment);
    }
}

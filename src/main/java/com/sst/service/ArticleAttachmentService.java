package com.sst.service;

import com.sst.mapper.ArticleAttachmentMapper;
import com.sst.entity.ArticleAttachment;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleAttachmentService {

    @Resource
    private ArticleAttachmentMapper articleAttachmentMapper;

    public int create(ArticleAttachment articleAttachment) {
        return articleAttachmentMapper.create(articleAttachment);
    }

    public int delete(Integer id) {
        return articleAttachmentMapper.delete(id);
    }

    public int update(ArticleAttachment articleAttachment) {
        return articleAttachmentMapper.update(articleAttachment);
    }

    public int updateSelective(ArticleAttachment articleAttachment) {
        return articleAttachmentMapper.updateSelective(articleAttachment);
    }

    public List<ArticleAttachment> query(ArticleAttachment articleAttachment) {
        return articleAttachmentMapper.query(articleAttachment);
    }

    public ArticleAttachment detail(Integer id) {
        return articleAttachmentMapper.detail(id);
    }

    public int count(ArticleAttachment articleAttachment) {
        return articleAttachmentMapper.count(articleAttachment);
    }
}

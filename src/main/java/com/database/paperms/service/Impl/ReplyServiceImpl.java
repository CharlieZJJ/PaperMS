package com.database.paperms.service.Impl;

import com.database.paperms.entity.Reply;
import com.database.paperms.mapper.ReplyMapper;
import com.database.paperms.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public int saveReply(Reply reply) {
        return replyMapper.insertReply(reply);
    }

    @Override
    public int deleteReply(Integer replyId) {
        return replyMapper.deleteReply(replyId);
    }

    @Override
    public int updateReply(Reply reply){return replyMapper.updateReply(reply);}

    @Override
    public Reply getReply(Integer replyId) {
        return replyMapper.getReply(replyId);
    }

    @Override
    public List<Reply> getByCommentId(Integer commentId) {
        return replyMapper.getByCommentId(commentId);
    }

}

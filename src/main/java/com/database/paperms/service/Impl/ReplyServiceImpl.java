package com.database.paperms.service.Impl;

import com.database.paperms.entity.Reply;
import com.database.paperms.entity.vo.PageHelper;
import com.database.paperms.mapper.ReplyMapper;
import com.database.paperms.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public int saveReply(Reply reply) {
        Date replyTime = new Date();
        reply.setReplyDate(replyTime);
        return replyMapper.insertReply(reply);
    }

    @Override
    public int deleteReply(Integer replyId) {
        return replyMapper.deleteReply(replyId);
    }

    @Override
    public int updateReply(Reply reply) {
        return replyMapper.updateReply(reply);
    }

    @Override
    public Reply getReply(Integer replyId) {
        return replyMapper.getReply(replyId);
    }

    @Override
    public List<Reply> getByCommentId(Integer commentId) {
        return replyMapper.getByCommentId(commentId);
    }

    @Override
    public PageHelper<Reply> listReply(Integer commentId, int pageSize, int pageNo) {
        List<Reply> list = replyMapper.listReply(commentId, (pageNo - 1) * pageSize, pageSize);
        PageHelper<Reply> userPageHelper = new PageHelper<>(list);
        userPageHelper.setTotal(replyMapper.count());
        userPageHelper.setPageSize(pageSize);
        userPageHelper.setPageNo(pageNo);
        return userPageHelper;
    }

}

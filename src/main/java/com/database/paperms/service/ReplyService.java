package com.database.paperms.service;


import com.database.paperms.entity.Reply;
import com.database.paperms.entity.vo.PageHelper;

import java.util.List;

public interface ReplyService {

    int saveReply(Reply reply);

    int deleteReply(Integer replyId);

    int updateReply(Reply reply);

    Reply getReply(Integer replyId);

    List<Reply> getByCommentId(Integer commentId);

    PageHelper<Reply> listReply(Integer commentId, int pageSize, int pageNo);

}

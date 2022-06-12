package com.database.paperms.service;


import com.database.paperms.entity.Reply;

import java.util.List;

public interface ReplyService {

    int saveReply(Reply reply);

    int deleteReply(Integer replyId);

    int updateReply(Reply reply);

    Reply getReply(Integer replyId);

    List<Reply> getByCommentId(Integer commentId);

}

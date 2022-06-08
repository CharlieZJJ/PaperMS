package com.database.paperms.service;


import com.database.paperms.entity.Reply;

import java.util.List;

public interface ReplyService {

    int saveReply(Reply reply);

    int deleteReply(Integer replyId);

    Reply getReply(Integer replyId);
    List<Reply> getByCommentId(Integer commentId);

}

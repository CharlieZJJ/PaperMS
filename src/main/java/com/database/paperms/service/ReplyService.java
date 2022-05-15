package com.database.paperms.service;


import com.database.paperms.entity.Reply;

public interface ReplyService {

    int saveReply(Reply reply);

    int deleteReply(Integer replyId);

    Reply getReply(Integer replyId);

}

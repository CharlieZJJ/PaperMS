package com.database.paperms.mapper;

import com.database.paperms.entity.Comment;
import com.database.paperms.entity.Reply;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyMapper {

    int insertReply(Reply reply);

    int deleteReply(Integer replyId);

    Reply getReply(Integer replyId);

}

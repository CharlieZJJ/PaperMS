package com.database.paperms.mapper;

import com.database.paperms.entity.Reply;
import com.database.paperms.entity.UserNote;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    int insertReply(Reply reply);

    int deleteReply(Integer replyId);

    int updateReply(Reply reply);

    Reply getReply(Integer replyId);

    List<Reply> getByCommentId(Integer commentId);

    List<Reply> listReply (Integer commentId, int offset, int pageSize);

    int count();

}

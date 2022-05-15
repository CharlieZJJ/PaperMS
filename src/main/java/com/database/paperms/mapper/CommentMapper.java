package com.database.paperms.mapper;

import com.database.paperms.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface CommentMapper {

    int insertComment(Comment comment);

    int deleteComment(Integer commentId);

    Comment getComment(Integer commentId);

}

package com.database.paperms.mapper;

import com.database.paperms.entity.Comment;
import com.database.paperms.entity.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface CommentMapper {

    int insertComment(Comment comment);

    int deleteComment(Integer commentId);

    Comment getComment(Integer commentId);

    List<Comment> getByPaperId(Integer paper_id);

    int removeComment(Integer commentId);

}

package com.database.paperms.mapper;

import com.database.paperms.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    int insertComment(Comment comment);

    int deleteComment(Integer commentId);

    int removeComment(Integer commentId);

    Comment getComment(Integer commentId);

    List<Comment> getByPaperId(Integer paper_id);

}

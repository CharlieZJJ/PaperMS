package com.database.paperms.service;

import com.database.paperms.entity.Comment;

import java.util.List;

public interface CommentService {

    int saveComment(Comment comment);

    int deleteComment(Integer commentId);

    Comment getComment(Integer commentId);

    List<Comment> getByPaperId(Integer paperId);

}

package com.database.paperms.service;

import com.database.paperms.entity.Comment;
import com.database.paperms.mapper.CommentMapper;

public interface CommentService {

    int saveComment(Comment comment);

    int deleteComment(Integer commentId);

    Comment getComment(Integer commentId);

}

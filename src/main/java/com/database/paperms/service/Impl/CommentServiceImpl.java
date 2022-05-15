package com.database.paperms.service.Impl;

import com.database.paperms.entity.Comment;
import com.database.paperms.mapper.CommentMapper;
import com.database.paperms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int saveComment(Comment comment){
        return commentMapper.insertComment(comment);
    }

    @Override
    public int deleteComment(Integer commentId){
        return commentMapper.deleteComment(commentId);
    }

    @Override
    public Comment getComment(Integer commentId){
        return commentMapper.getComment(commentId);
    }

}

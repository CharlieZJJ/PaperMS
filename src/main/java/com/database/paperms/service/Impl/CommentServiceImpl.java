package com.database.paperms.service.Impl;

import com.database.paperms.entity.Comment;
import com.database.paperms.entity.vo.PageHelper;
import com.database.paperms.mapper.CommentMapper;
import com.database.paperms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int saveComment(Comment comment) {
        Date commentTime = new Date();
        comment.setCommentDate(commentTime);
        return commentMapper.insertComment(comment);
    }

    @Override
    public int deleteComment(Integer commentId) {
        return commentMapper.deleteComment(commentId);
    }

    @Override
    public int removeComment(Integer commentId) {
        return commentMapper.removeComment(commentId);
    }

    @Override
    public int updateComment(Comment comment) {
        Date commentTime = new Date();
        comment.setCommentDate(commentTime);
        return commentMapper.updateComment(comment);
    }

    @Override
    public Comment getComment(Integer commentId) {
        return commentMapper.getComment(commentId);
    }

    @Override
    public List<Comment> getByPaperId(Integer paperId) {
        return commentMapper.getByPaperId(paperId);
    }

    @Override
    public PageHelper<Comment> listComment(Integer paperId, int pageSize, int pageNo) {
        List<Comment> list = commentMapper.listComment(paperId, (pageNo - 1) * pageSize, pageSize);
        PageHelper<Comment> userPageHelper = new PageHelper<>(list);
        userPageHelper.setTotal(commentMapper.count());
        userPageHelper.setPageSize(pageSize);
        userPageHelper.setPageNo(pageNo);
        return userPageHelper;
    }

}

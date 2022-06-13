package com.database.paperms.service;

import com.database.paperms.entity.Comment;
import com.database.paperms.entity.Reply;
import com.database.paperms.entity.vo.PageHelper;

import java.util.List;

public interface CommentService {

    int saveComment(Comment comment);

    int deleteComment(Integer commentId);

    int removeComment(Integer commentId);

    int updateComment(Comment comment);

    Comment getComment(Integer commentId);

    List<Comment> getByPaperId(Integer paperId);

    PageHelper<Comment> listComment (Integer paperId, int pageSize, int pageNo);

}

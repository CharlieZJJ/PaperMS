package com.database.paperms.service.Impl;

import com.database.paperms.entity.Comment;
import com.database.paperms.entity.Reply;
import com.database.paperms.entity.vo.CommentUserVO;
import com.database.paperms.entity.vo.CommentVO;
import com.database.paperms.entity.vo.PageHelper;
import com.database.paperms.entity.vo.ReplyVO;
import com.database.paperms.mapper.CommentMapper;
import com.database.paperms.mapper.ReplyMapper;
import com.database.paperms.mapper.UserMapper;
import com.database.paperms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private UserMapper userMapper;

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
    public List<CommentVO> showComment(Integer paperId) {
        List<CommentVO> commentVOList = new ArrayList<>();
        List<Comment> commentList = commentMapper.getByPaperId(paperId);
        for(int i=0;i<commentList.size();i++){
            Comment comment = commentList.get(i);
            CommentVO commentVO = new CommentVO();
            List<ReplyVO> childrenList = new ArrayList<>();
            List<Reply> replyList = replyMapper.getByCommentId(comment.getCommentId());
            for(int j=0;j<replyList.size();j++){
                Reply reply = replyList.get(j);
                String replyName = userMapper.getById(reply.getReplyUserId()).getUserName();
                String replyToName = userMapper.getById(reply.getReplyUserToId()).getUserName();
                ReplyVO replyVO = new ReplyVO();
                CommentUserVO replyUser = new CommentUserVO();
                CommentUserVO replyToUser = new CommentUserVO();
                replyUser.setAvatar(null);
                replyUser.setNickName(replyName);
                replyUser.setId(reply.getReplyUserId());

                replyToUser.setAvatar(null);
                replyToUser.setNickName(replyToName);
                replyToUser.setId(reply.getReplyUserToId());

                replyVO.setCommentUser(replyUser);
                replyVO.setContent(reply.getReplyContent());
                replyVO.setCreateDate(reply.getReplyDate());
                replyVO.setId(reply.getReplyId());
                replyVO.setTargetUser(replyToUser);
                childrenList.add(replyVO);
            }
            CommentUserVO commentUserVO = new CommentUserVO();
            String commentName = userMapper.getById(comment.getCommentUserId()).getUserName();
            commentUserVO.setAvatar(null);
            commentUserVO.setId(comment.getCommentUserId());
            commentUserVO.setNickName(commentName);

            commentVO.setChildrenList(childrenList);
            commentVO.setCommentUser(commentUserVO);
            commentVO.setContent(comment.getCommentContent());
            commentVO.setCreateDate(comment.getCommentDate());
            commentVO.setTargetUser(null);
            commentVO.setId(comment.getCommentId());
            commentVOList.add(commentVO);
        }
        return commentVOList;
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

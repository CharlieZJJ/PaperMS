package com.database.paperms.controller;

import com.database.paperms.entity.Comment;
import com.database.paperms.entity.Reply;
import com.database.paperms.response.ResultData;
import com.database.paperms.response.ReturnCode;
import com.database.paperms.service.CommentService;
import com.database.paperms.service.ReplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;
    @Resource
    private ReplyService replyService;

    @Resource
    private HttpSession session;

    @PostMapping("/add")
    public ResultData add(@RequestBody Comment comment) {
        Integer commentId = (Integer) session.getAttribute("user_id");
        comment.setCommentUserId(commentId);
        commentService.saveComment(comment);
        return ResultData.success();
    }

    @DeleteMapping("/delete/{id}")
    public ResultData delete(@PathVariable("id") Integer commentId) {
        if (commentService.getComment(commentId) != null) {
            List<Reply> replyList = replyService.getByCommentId(commentId);
            for (int i = 0; i < replyList.size(); i++) {
                Reply reply = replyList.get(i);
                replyService.deleteReply(reply.getReplyId());
            }
            commentService.deleteComment(commentId);
            return ResultData.success();
        } else {
            return ResultData.fail(ReturnCode.NOT_EXISTENT_COMMENT);
        }
    }

    @PostMapping("/remove/{id}")
    public ResultData remove(@PathVariable("id") Integer commentId) {
        if (commentService.getComment(commentId) != null) {
            commentService.removeComment(commentId);
            return ResultData.success();
        } else {
            return ResultData.fail(ReturnCode.NOT_EXISTENT_COMMENT);
        }
    }

    @PostMapping("/update")
    public ResultData update(@RequestBody Comment comment) {
        if (commentService.getComment(comment.getCommentId()) != null) {
            commentService.updateComment(comment);
            return ResultData.success();
        } else {
            return ResultData.fail(ReturnCode.NOT_EXISTENT_COMMENT);
        }
    }
}

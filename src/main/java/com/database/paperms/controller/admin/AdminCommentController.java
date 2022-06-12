package com.database.paperms.controller.admin;

import com.database.paperms.entity.Reply;
import com.database.paperms.response.ResultData;
import com.database.paperms.response.ReturnCode;
import com.database.paperms.service.CommentService;
import com.database.paperms.service.ReplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/comment")
public class AdminCommentController {

    @Resource
    private CommentService commentService;

    @Resource
    private ReplyService replyService;

    @PostMapping("/remove/{id}")
    public ResultData remove(@PathVariable("id") Integer commentId) {
        commentService.removeComment(commentId);
        return ResultData.success();
    }
}

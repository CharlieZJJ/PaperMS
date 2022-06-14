package com.database.paperms.controller.admin;

import com.database.paperms.response.ResultData;
import com.database.paperms.service.CommentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/comment")
public class AdminCommentController {

    @Resource
    private CommentService commentService;

    @PostMapping("/remove/{id}")
    public ResultData remove(@PathVariable("id") Integer commentId) {
        commentService.removeComment(commentId);
        return ResultData.success();
    }
}

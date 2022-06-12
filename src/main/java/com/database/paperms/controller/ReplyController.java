package com.database.paperms.controller;

import com.database.paperms.entity.Comment;
import com.database.paperms.entity.Reply;
import com.database.paperms.response.ResultData;
import com.database.paperms.response.ReturnCode;
import com.database.paperms.service.ReplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Resource
    private ReplyService replyService;

    @PostMapping("/add")
    public ResultData add(@RequestBody Reply reply) {
        replyService.saveReply(reply);
        return ResultData.success();
    }

    @DeleteMapping("/delete/{id}")
    public ResultData delete(@PathVariable("id") Integer replyId) {
        if (replyService.getReply(replyId) != null) {
            replyService.deleteReply(replyId);
            return ResultData.success();
        } else {
            return ResultData.fail(ReturnCode.NOT_EXISTENT_REPLY);
        }
    }

    @PostMapping("/update")
    public ResultData update(@RequestBody Reply reply) {
        if (replyService.getReply(reply.getReplyId()) != null) {
            replyService.updateReply(reply);
            return ResultData.success();
        } else {
            return ResultData.fail(ReturnCode.NOT_EXISTENT_COMMENT);
        }
    }
}

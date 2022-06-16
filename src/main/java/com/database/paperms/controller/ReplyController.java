package com.database.paperms.controller;

import com.database.paperms.entity.Reply;
import com.database.paperms.entity.vo.PageHelper;
import com.database.paperms.response.ResultData;
import com.database.paperms.response.ReturnCode;
import com.database.paperms.service.ReplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Resource
    private ReplyService replyService;

    @Resource
    private HttpSession session;

    @PostMapping("/add")
    public ResultData add(@RequestBody Reply reply) {
        Integer replyId = (Integer) session.getAttribute("user_id");
        reply.setReplyUserId(replyId);
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

    @PutMapping("/list")
    public ResultData list(@RequestParam Integer commentId, @RequestParam int pageSize, @RequestParam int pageNo) {
        PageHelper<Reply> list = replyService.listReply(commentId, pageSize, pageNo);
        return ResultData.success(list);
    }

}

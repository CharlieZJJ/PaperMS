package com.database.paperms.controller.admin;

import com.database.paperms.response.ResultData;
import com.database.paperms.response.ReturnCode;
import com.database.paperms.service.ReplyService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/reply")
public class AdminReplyController {
    @Resource
    private ReplyService replyService;

    @DeleteMapping("/delete/{id}")
    public ResultData delete(@PathVariable("id") Integer replyId) {
        if (replyService.getReply(replyId) != null) {
            replyService.deleteReply(replyId);
            return ResultData.success();
        } else {
            return ResultData.fail(ReturnCode.NOT_EXISTENT_REPLY);
        }
    }
}

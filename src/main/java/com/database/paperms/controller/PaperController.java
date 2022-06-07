package com.database.paperms.controller;

import cn.hutool.core.util.RandomUtil;
import com.database.paperms.entity.Comment;
import com.database.paperms.entity.Paper;
import com.database.paperms.entity.Reply;
import com.database.paperms.entity.User;
import com.database.paperms.response.ResultData;
import com.database.paperms.response.ReturnCode;
import com.database.paperms.service.CommentService;
import com.database.paperms.service.PaperService;
import com.database.paperms.service.ReplyService;
import com.database.paperms.utils.RegexUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/paper")
public class PaperController {
    @Resource
    private PaperService paperService;

    @Resource
    private CommentService commentService;

    @Resource
    private CommentController commentController;

    @PostMapping("/add")
    public ResultData add(@RequestBody Paper paper) {
        if (paperService.getByLink(paper.getPaperLink()) == null) {
            paperService.savePaper(paper);
            return ResultData.success();
        } else {
            return ResultData.fail(ReturnCode.USED_PAPER_LINK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResultData delete(@PathVariable("id") Integer paperId) {
        if (paperService.getPaper(paperId) != null) {
            List<Comment> commentList = commentService.getByPaperId(paperId);
            for(int i=0;i<commentList.size();i++){
                Comment comment = commentList.get(i);
                commentController.delete(comment.getCommentId());
            }
            paperService.deletePaper(paperId);
            return ResultData.success();
        } else {
            return ResultData.fail(ReturnCode.NOT_EXISTENT_PAPER_ID);
        }
    }

    @PostMapping("/update")
    public ResultData update(@RequestBody Paper paper) {
        if (paperService.getPaper(paper.getPaperId()) != null) {
            paperService.updatePaper(paper);
            return ResultData.success();
        } else {
            return ResultData.fail(ReturnCode.NOT_EXISTENT_PAPER_ID);
        }
    }

}

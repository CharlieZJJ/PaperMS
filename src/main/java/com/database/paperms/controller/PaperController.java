package com.database.paperms.controller;

import com.database.paperms.entity.Comment;
import com.database.paperms.entity.Paper;
import com.database.paperms.entity.vo.AdvancedSearchValue;
import com.database.paperms.entity.vo.PageHelper;
import com.database.paperms.entity.vo.PaperVO;
import com.database.paperms.response.ResultData;
import com.database.paperms.response.ReturnCode;
import com.database.paperms.service.CommentService;
import com.database.paperms.service.PaperService;
import com.database.paperms.service.UserService;
import com.database.paperms.utils.CopyUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/paper")
public class PaperController {
    @Resource
    private PaperService paperService;

    @Resource
    private CommentService commentService;

    @Resource
    private UserService userService;

    @Resource
    private CommentController commentController;

    @Resource
    private CopyUtil copyUtil;

    @Resource
    private HttpSession session;

    @PostMapping("/add")
    public ResultData add(@RequestBody Paper paper,@RequestParam String userAccount) {
        if (paperService.getByLink(paper.getPaperLink()) == null) {
            Integer publisherId = userService.getIdByAccount(userAccount);
            paper.setPaperPublisherId(publisherId);
            paperService.savePaper(paper);
            return ResultData.success();
        } else {
            return ResultData.fail(ReturnCode.USED_PAPER_LINK);
        }
    }

    @PostMapping("/add/getId")
    public ResultData getCitationIdByLink(@RequestBody List<String> citationLink){
        List<Integer> idList=new ArrayList<>();
        for(int i=0;i<citationLink.size();i++){
            if(paperService.getCitationIdByLink(citationLink.get(i)) != null) {
                Integer id = paperService.getCitationIdByLink(citationLink.get(i));
                idList.add(id);
            }
        }
        return ResultData.success(idList);
    }

    @DeleteMapping("/delete/{id}")
    public ResultData delete(@PathVariable("id") Integer paperId) {
        if (paperService.getPaper(paperId) != null) {
            List<Comment> commentList = commentService.getByPaperId(paperId);
            for (int i = 0; i < commentList.size(); i++) {
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

    @GetMapping("/list")
    public ResultData research(@RequestParam int pageSize, @RequestParam int pageNo, @RequestParam(required = false) String type, @RequestParam(required = false) String information, @RequestParam(defaultValue = "0") int sort) {
        if (!type.equals("title") && !type.equals("summary") && !type.equals("direction") && !type.equals("author") && type != null)
            return ResultData.fail(-1, "无效的类型");
        if (pageSize <= 0 || pageNo <= 0)
            return ResultData.fail(-1, "分页有关内容不能为负数");
        PageHelper<PaperVO> list = paperService.list(type, information, sort, pageSize, pageNo);
        return ResultData.success(list);
    }

    @PostMapping("/list/advanced")
    public ResultData advanced_research(@RequestBody AdvancedSearchValue value, @RequestParam int pageSize, @RequestParam int pageNo, @RequestParam(required = false, defaultValue = "0") int sort) {
        if (pageSize <= 0 || pageNo <= 0)
            return ResultData.fail(-1, "分页有关内容不能为负数");
        ArrayList<Integer> paperTypeInts = new ArrayList<>();
        List<String> paperType = value.getPaperType();
        if (paperType.size() != 0) {
            for (String s : paperType) {
                int type;
                switch (s) {
                    case "理论证明型":
                        type = 0;
                        break;
                    case "综述型":
                        type = 1;
                        break;
                    case "实验型":
                        type = 2;
                        break;
                    case "工具型":
                        type = 3;
                        break;
                    case "数据集型":
                        type = 4;
                        break;
                    case "":
                        type = -1;
                        break;
                    default:
                        return ResultData.fail(-1, "不合理的论文类型");
                }
                paperTypeInts.add(type);
            }
        }
        value.setPaperTypeInt(paperTypeInts);
        PageHelper<PaperVO> list = null;
        try {
            list = paperService.advanced_list(value, pageSize, pageNo, sort);
        } catch (Exception e) {
            return ResultData.fail(-1, "您的搜索条件有误，请检查！");
        }
        return ResultData.success(list);
    }

}

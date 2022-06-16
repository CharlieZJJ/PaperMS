package com.database.paperms.controller;

import com.database.paperms.entity.Comment;
import com.database.paperms.entity.dto.PaperDTO;
import com.database.paperms.entity.vo.*;
import com.database.paperms.response.ResultData;
import com.database.paperms.response.ReturnCode;
import com.database.paperms.service.CommentService;
import com.database.paperms.service.PaperService;
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
    private CommentController commentController;

    @Resource
    private HttpSession session;


    @PostMapping("/add")
    public ResultData add(@RequestBody PaperDTO paperDTO) {
        if (paperDTO.getPaperType() < 0 || paperDTO.getPaperType() > 4)
            return ResultData.fail(ReturnCode.PAPER_TYPE_RANGE_ERROR);
        if (paperService.getByLink(paperDTO.getPaperLink()) == null) {
            Integer user_id = (Integer) session.getAttribute("user_id");
            paperDTO.setPaperPublisherId(user_id);
            int i = paperService.savePaper(paperDTO);
            if (i < 0) return ResultData.fail(ReturnCode.TIME_FORMAT_ERROR);
            return ResultData.success();
        } else {
            return ResultData.fail(ReturnCode.USED_PAPER_LINK);
        }

    }

    @PostMapping("/add/getId")
    public ResultData getCitationIdByLink(@RequestBody List<CitationLinkVO> citationLink) {
        List<Integer> idList = new ArrayList<>();
        for (int i = 0; i < citationLink.size(); i++) {
            if (paperService.getCitationIdByLink(citationLink.get(i).getValue()) != null) {
                Integer id = paperService.getCitationIdByLink(citationLink.get(i).getValue());
                idList.add(id);
            }
        }
        return ResultData.success(idList);
    }

    @PostMapping("/getCitation/{id}")
    public ResultData getCitation(@PathVariable("id") Integer paperId) {
        List<PaperCitationStrVO> listCitation = paperService.getCitation(paperId);
        return ResultData.success(listCitation);
    }

    @PostMapping("/show/{id}")
    public ResultData show(@PathVariable("id") Integer paperId) {
        PaperVO paperVO = paperService.showPaper(paperId);
        return ResultData.success(paperVO);
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
    public ResultData update(@RequestBody PaperDTO paperDTO) {
        int i = paperService.updatePaper(paperDTO);
        if(i == -1)
            return ResultData.fail(ReturnCode.NOT_EXISTENT_PAPER_ID);
        else return ResultData.success();
    }

    @GetMapping("/list")
    public ResultData research(@RequestParam int pageSize, @RequestParam int pageNo, @RequestParam(required = false) String type, @RequestParam(required = false) String information, @RequestParam(defaultValue = "0") int sort) {
        if (!type.equals("title") && !type.equals("summary") && !type.equals("direction") && !type.equals("author") && type != null)
            return ResultData.fail(ReturnCode.ILLEGAL_SEARCH_TYPE);
        if (pageSize <= 0 || pageNo <= 0)
            return ResultData.fail(ReturnCode.PAGE_PARAMETER_ERROR);
        PageHelper<PaperVO> list = paperService.list(type, information, sort, pageSize, pageNo);
        return ResultData.success(list);
    }

    @PostMapping("/list/advanced")
    public ResultData advanced_research(@RequestBody AdvancedSearchValue value, @RequestParam int pageSize, @RequestParam int pageNo, @RequestParam(required = false, defaultValue = "0") int sort) {
        if (pageSize <= 0 || pageNo <= 0)
            return ResultData.fail(ReturnCode.PAGE_PARAMETER_ERROR);
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
                        return ResultData.fail(ReturnCode.PAPER_TYPE_RANGE_ERROR);
                }
                paperTypeInts.add(type);
            }
        }
        value.setPaperTypeInt(paperTypeInts);
        PageHelper<PaperVO> list = null;
        try {
            list = paperService.advanced_list(value, pageSize, pageNo, sort);
        } catch (Exception e) {
            return ResultData.fail(ReturnCode.SEARCH_CONDITION_ERROR);
        }
        return ResultData.success(list);
    }

}

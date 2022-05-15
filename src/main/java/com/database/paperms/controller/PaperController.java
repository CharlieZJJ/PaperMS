package com.database.paperms.controller;

import cn.hutool.core.util.RandomUtil;
import com.database.paperms.entity.Paper;
import com.database.paperms.entity.User;
import com.database.paperms.response.ResultData;
import com.database.paperms.response.ReturnCode;
import com.database.paperms.service.PaperService;
import com.database.paperms.utils.RegexUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/paper")
public class PaperController {

    @Resource
    private PaperService paperService;

    @PostMapping("/add")
    public ResultData add(@RequestBody Paper paper){
        try {
            if(paper.getPaperId() != null) {
                if (paperService.getPaper(paper.getPaperId()) == null) {
                    paperService.savePaper(paper);
                    return ResultData.success();
                } else {
                    return ResultData.fail(ReturnCode.USED_PAPER_ID);
                }
            }
        }catch(ClassCastException e){
            e.printStackTrace();
        }
        return ResultData.fail(ReturnCode.CLASS_CAST_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    public ResultData delete(@PathVariable("id") Integer paperId){
        if(paperService.getPaper(paperId) != null){
            paperService.deletePaper(paperId);
            return ResultData.success();
        }else{
            return ResultData.fail(ReturnCode.NOT_EXISTENT_PAPER_ID);
        }
    }

    @PostMapping("/update")
    public ResultData update(@RequestBody Paper paper){
        if(paperService.getPaper(paper.getPaperId()) != null){
            paperService.updatePaper(paper);
            return ResultData.success();
        }else{
            return ResultData.fail(ReturnCode.NOT_EXISTENT_PAPER_ID);
        }
    }



}

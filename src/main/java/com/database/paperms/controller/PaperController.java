package com.database.paperms.controller;

import cn.hutool.core.util.RandomUtil;
import com.database.paperms.entity.Paper;
import com.database.paperms.entity.User;
import com.database.paperms.response.ResultData;
import com.database.paperms.response.ReturnCode;
import com.database.paperms.service.PaperService;
import com.database.paperms.utils.RegexUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/paper")
public class PaperController {

    @Resource
    private PaperService paperService;

    @PostMapping("/add")
    public ResultData add(@RequestBody Paper paper){
        try {
            paperService.savePaper(paper);
            return ResultData.success();
        }catch(ClassCastException e){
            e.printStackTrace();
        }
        return ResultData.fail(ReturnCode.CLASS_CAST_ERROR);
    }






}

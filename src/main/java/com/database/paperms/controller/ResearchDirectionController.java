package com.database.paperms.controller;


import com.database.paperms.entity.Paper;
import com.database.paperms.entity.Reply;
import com.database.paperms.entity.ResearchDirection;
import com.database.paperms.entity.vo.PageHelper;
import com.database.paperms.entity.vo.PaperVO;
import com.database.paperms.response.ResultData;
import com.database.paperms.response.ReturnCode;
import com.database.paperms.service.PaperService;
import com.database.paperms.service.ResearchDirectionService;
import com.database.paperms.utils.TreeNode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/rd")
public class ResearchDirectionController {

    @Resource
    private ResearchDirectionService rdService;

    @Resource
    private PaperService paperService;

    @PostMapping("/add")
    public ResultData add(@RequestBody ResearchDirection researchDirection) {
        rdService.saveResearchDirection(researchDirection);
        return ResultData.success();
    }

    @DeleteMapping("/delete/{id}")
    public ResultData delete(@PathVariable("id") Integer rdId) {
        rdService.deleteResearchDirection(rdId);
        return ResultData.success();
    }

    @PostMapping("/update")
    public ResultData update(@RequestBody ResearchDirection researchDirection) {
        rdService.updateResearchDirection(researchDirection);
        return ResultData.success();
    }

    @GetMapping("/list")
    public ResultData list() {
        List<TreeNode<ResearchDirection>> list = null;
        try {
            list = rdService.list();
        } catch (NullPointerException e) {
            return ResultData.fail(-1, "研究方向数据出现问题，请维护");
        }
        if (list == null)
            return ResultData.fail(-1, "获取数据失败");
        return ResultData.success(list);
    }

    @GetMapping("/find")
    public ResultData find(@RequestParam String name, @RequestParam int pageSize, @RequestParam int pageNo) {
        PageHelper<PaperVO> byRd = paperService.getByRd(pageSize, pageNo, name);
        return ResultData.success(byRd);
    }


}

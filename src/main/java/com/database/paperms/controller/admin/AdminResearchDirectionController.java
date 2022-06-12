package com.database.paperms.controller.admin;

import com.database.paperms.entity.ResearchDirection;
import com.database.paperms.response.ResultData;
import com.database.paperms.service.ResearchDirectionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/rd")
public class AdminResearchDirectionController {

    @Resource
    private ResearchDirectionService researchDirectionService;

    @PostMapping("/add")
    public ResultData add(@RequestBody ResearchDirection researchDirection) {
        researchDirectionService.saveResearchDirection(researchDirection);
        return ResultData.success();
    }

    @DeleteMapping("/delete/{id}")
    public ResultData delete(@PathVariable("id") Integer rdId) {
        researchDirectionService.deleteResearchDirection(rdId);
        return ResultData.success();
    }

    @PostMapping("/update")
    public ResultData update(@RequestBody ResearchDirection researchDirection) {
        researchDirectionService.updateResearchDirection(researchDirection);
        return ResultData.success();
    }

}

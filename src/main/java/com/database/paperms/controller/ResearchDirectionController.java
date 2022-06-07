package com.database.paperms.controller;

import com.database.paperms.entity.Reply;
import com.database.paperms.entity.ResearchDirection;
import com.database.paperms.response.ResultData;
import com.database.paperms.response.ReturnCode;
import com.database.paperms.service.ResearchDirectionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigInteger;

@RestController
@RequestMapping("/researchdirection")
public class ResearchDirectionController {
    @Resource
    private ResearchDirectionService researchDirectionService;

    @PostMapping("/add")
    public ResultData add(@RequestBody ResearchDirection researchDirection){
        if(researchDirectionService.getResearchDirection(researchDirection.getRdId()) ==null){
            researchDirectionService.saveResearchDirection(researchDirection);
            return ResultData.success();
        }else{
            return ResultData.fail(ReturnCode.EXISTED_RESEARCH_DIRECTION);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResultData delete(@PathVariable("id") BigInteger rdId){
        if(researchDirectionService.getResearchDirection(rdId) !=null){
            researchDirectionService.deleteResearchDirection(rdId);
            return ResultData.success();
        }else{
            return ResultData.fail(ReturnCode.NOT_EXISTENT_RESEARCH_DIRECTION);
        }
    }

    @PostMapping("/update")
    public ResultData update(@RequestBody ResearchDirection researchDirection){
        if(researchDirectionService.getResearchDirection(researchDirection.getRdId()) !=null){
            researchDirectionService.updateResearchDirection(researchDirection);
            return ResultData.success();
        }else{
            return ResultData.fail(ReturnCode.NOT_EXISTENT_RESEARCH_DIRECTION);
        }
    }

}

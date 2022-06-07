package com.database.paperms.service.Impl;

import com.database.paperms.entity.Reply;
import com.database.paperms.entity.ResearchDirection;
import com.database.paperms.mapper.ResearchDirectionMapper;
import com.database.paperms.service.ResearchDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class ResearchDirectionServiceImpl implements ResearchDirectionService {
    @Autowired
    private ResearchDirectionMapper researchDirectionMapper;

    @Override
    public int saveResearchDirection(ResearchDirection researchDirection){return researchDirectionMapper.insertResearchDirection(researchDirection);}

    @Override
    public int deleteResearchDirection(BigInteger rdId){return researchDirectionMapper.deleteResearchDirection(rdId); }

    @Override
    public ResearchDirection getResearchDirection(BigInteger rdId){return researchDirectionMapper.getResearchDirection(rdId); }

    @Override
    public int updateResearchDirection(ResearchDirection researchDirection){return researchDirectionMapper.updateResearchDirection(researchDirection);}
}

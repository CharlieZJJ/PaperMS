package com.database.paperms.service;

import com.database.paperms.entity.Reply;
import com.database.paperms.entity.ResearchDirection;

import java.math.BigInteger;
import java.util.List;

public interface ResearchDirectionService {

    int saveResearchDirection(ResearchDirection researchDirection);

    int deleteResearchDirection(BigInteger rdId);

    ResearchDirection getResearchDirection(BigInteger rdId);

    int updateResearchDirection(ResearchDirection researchDirection);

}

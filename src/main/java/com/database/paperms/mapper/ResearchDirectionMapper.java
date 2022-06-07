package com.database.paperms.mapper;

import com.database.paperms.entity.Paper;
import com.database.paperms.entity.Reply;
import com.database.paperms.entity.ResearchDirection;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;

@Mapper
public interface ResearchDirectionMapper {

    int insertResearchDirection(ResearchDirection researchDirection);

    int deleteResearchDirection(BigInteger rdId);

    ResearchDirection getResearchDirection(BigInteger rdId);

    int updateResearchDirection(ResearchDirection researchDirection);

}

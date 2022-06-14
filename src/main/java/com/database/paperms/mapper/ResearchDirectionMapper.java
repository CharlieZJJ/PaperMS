package com.database.paperms.mapper;

import com.database.paperms.entity.ResearchDirection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResearchDirectionMapper {

    int insertResearchDirection(ResearchDirection researchDirection);

    int deleteResearchDirection(Integer rdId);

    int updateResearchDirection(ResearchDirection researchDirection);

    List<ResearchDirection> list();

    String getById(String id);


}

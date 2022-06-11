package com.database.paperms.mapper;

import com.database.paperms.entity.ResearchDirection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResearchDirectionMapper {

    List<ResearchDirection> list();

}

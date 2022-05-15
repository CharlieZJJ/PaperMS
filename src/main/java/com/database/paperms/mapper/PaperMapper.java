package com.database.paperms.mapper;

import com.database.paperms.entity.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface PaperMapper {

    int insertPaper(Paper paper);

    Paper getPaper(Integer paperId);

    int deletePaper(Integer paperId);

    int updatePaper(Paper paper);

}

package com.database.paperms.mapper;

import com.database.paperms.entity.Paper;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface PaperMapper {

    int insertPaper(Paper paper);

    Paper getPaper(Integer paperId);

    Paper getByLink(String paperLink);

    int deletePaper(Integer paperId);

    int updatePaper(Paper paper);

    Page<Paper> list(String type, String cond, int sort);

    List<String> getPaperAuthor(int paperId);

    List<Integer> getPaperCitation(int paperId);

    List<String> getPaperRd(int paperId);

    List<String> getPaperAdditionalFile(int paperId);

}

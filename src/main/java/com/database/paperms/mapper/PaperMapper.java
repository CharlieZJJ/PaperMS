package com.database.paperms.mapper;

import com.database.paperms.entity.FileEntity;
import com.database.paperms.entity.Paper;
import com.database.paperms.entity.ResearchDirection;
import com.database.paperms.entity.SmallPaper;
import com.database.paperms.entity.vo.AdvancedSearchValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaperMapper {

    int insertPaper(Paper paper);

    Paper getPaper(Integer paperId);

    Paper getByLink(String paperLink);

    int deletePaper(Integer paperId);

    int updatePaper(Paper paper);

    List<Paper> list(String type, String cond, int sort);

    List<String> getPaperAuthor(int paperId);

    List<Integer> getPaperCitation(int paperId);

    List<ResearchDirection> getPaperRd(int paperId);

    List<FileEntity> getPaperAdditionalFile(int paperId);

    List<SmallPaper> getSmallPaper(List<Integer> paperCitationId);

    List<Paper> advanced_list(AdvancedSearchValue value, int pageSize, int pageNo, int sort) throws Exception;

    List<Paper> getPaperByAccount(String account, int sort);

    List<Paper> getByRd(String rd);

}

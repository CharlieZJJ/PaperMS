package com.database.paperms.mapper;

import com.database.paperms.entity.FileEntity;
import com.database.paperms.entity.Paper;
import com.database.paperms.entity.ResearchDirection;
import com.database.paperms.entity.SmallPaper;
import com.database.paperms.entity.vo.AdvancedSearchValue;
import com.database.paperms.entity.vo.rdCount;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface PaperMapper {

    int insertPaper(Paper paper);

    int insertPaperRd(Integer paperId, String rdId);

    int insertPaperAuthor(Integer paperId, String authorName);

    int insertPaperCitation(Integer paperId, Integer citationId);

    int insertPaperAdditionalFile(Integer paperId, String filePath, String fileName, Double fileSize);

    Paper getPaper(Integer paperId);

    Integer getCitationIdByLink(String citationLink);

    Paper getByLink(String paperLink);

    int deletePaper(Integer paperId);

    int deletePaperRd(Integer paperId);

    int deletePaperAuthor(Integer paperId);

    int deletePaperCitation(Integer paperId);

    int deletePaperAdditionalFile(Integer paperId);

    int updatePaper(Paper paper);

    List<Paper> list(String type, String cond, int sort);

    List<String> getPaperAuthor(int paperId);

    List<Integer> getPaperCitation(int paperId);

    List<ResearchDirection> getPaperRd(int paperId);

    List<FileEntity> getPaperAdditionalFile(int paperId);

    List<SmallPaper> getSmallPaper(List<Integer> paperCitationId);

    List<Paper> advanced_list(AdvancedSearchValue value, int pageSize, int pageNo, int sort) throws Exception;

    List<Paper> getPaperByAccount(String account, int sort);

    List<Paper> getByRd(String rdId);

    int countByUserId(int userId);

    int countByUserIdWithRange(Date lowerBound, Integer userId);

    List<rdCount> countRd(Integer userId);

}

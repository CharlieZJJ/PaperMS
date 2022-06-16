package com.database.paperms.service;

import com.database.paperms.entity.Paper;
import com.database.paperms.entity.dto.PaperDTO;
import com.database.paperms.entity.vo.*;

import java.util.List;

public interface PaperService {
    int savePaper(PaperDTO paperDTO);

    Paper getPaper(Integer paperId);

    public PaperVO showPaper(Integer paperId);

    public String showNote(Integer userId,Integer paperId);

    Paper getByLink(String paperLink);

    Integer getCitationIdByLink(String citationLink);

    List<PaperCitationStrVO> getCitation(Integer paperId);

    int deletePaper(Integer paperId);

    int updatePaper(PaperDTO paperDTO);

    PageHelper<PaperVO> list(String type, String cond, int sort, int pageSize, int pageNo);

    PageHelper<PaperVO> advanced_list(AdvancedSearchValue value, int pageSize, int pageNo, int sort) throws Exception;

    PageHelper<PaperVO> getByAccount(String account, int pageSize, int pageNo, int sort);

    PageHelper<PaperVO> getByRd(int pageSize, int pageNo, String rdId);

    Data count(int timeRange, int userId);

}


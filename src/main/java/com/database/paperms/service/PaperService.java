package com.database.paperms.service;

import com.database.paperms.entity.Paper;
import com.database.paperms.entity.ResearchDirection;
import com.database.paperms.entity.vo.AdvancedSearchValue;
import com.database.paperms.entity.vo.PageHelper;
import com.database.paperms.entity.vo.PaperVO;

public interface PaperService {
    int savePaper(Paper paper);

    Paper getPaper(Integer paperId);

    Paper getByLink(String paperLink);

    int deletePaper(Integer paperId);

    int updatePaper(Paper paper);

    PageHelper<PaperVO> list(String type, String cond, int sort, int pageSize, int pageNo);

    PageHelper<PaperVO> advanced_list(AdvancedSearchValue value, int pageSize, int pageNo, int sort) throws Exception;

    PageHelper<PaperVO> getByAccount(String account, int pageSize, int pageNo, int sort);

    PageHelper<PaperVO> getByRd(int pageSize, int pageNo, String rd);

}


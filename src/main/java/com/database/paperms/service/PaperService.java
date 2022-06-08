package com.database.paperms.service;

import com.database.paperms.entity.Paper;
import com.github.pagehelper.Page;

public interface PaperService {
    int savePaper(Paper paper);

    Paper getPaper(Integer paperId);

    Paper getByLink(String paperLink);

    int deletePaper(Integer paperId);

    int updatePaper(Paper paper);

    Page<Paper> list(String type, String cond, int sort);

}


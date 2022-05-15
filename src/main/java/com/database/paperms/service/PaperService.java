package com.database.paperms.service;

import com.database.paperms.entity.Paper;

public interface PaperService {
    int savePaper(Paper paper);

    Paper getPaper(Integer paperId);

    int deletePaper(Integer paperId);

    int updatePaper(Paper paper);

}


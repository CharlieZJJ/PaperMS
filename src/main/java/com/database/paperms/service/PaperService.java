package com.database.paperms.service;

import com.database.paperms.entity.Paper;

public interface PaperService {
    int savePaper(Paper paper);

    Paper getPaper(Integer paperId);

    Paper getByLink(String paperLink);

    int deletePaper(Integer paperId);

    int updatePaper(Paper paper);

    int deletePaperRd(Integer paperId,Long paperRd);

}


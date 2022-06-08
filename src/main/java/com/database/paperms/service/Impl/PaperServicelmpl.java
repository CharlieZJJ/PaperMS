package com.database.paperms.service.Impl;

import com.database.paperms.entity.Paper;
import com.database.paperms.mapper.PaperMapper;
import com.database.paperms.service.PaperService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperServicelmpl implements PaperService {
    @Autowired
    private PaperMapper paperMapper;

    @Override
    public int savePaper(Paper paper){
        return paperMapper.insertPaper(paper);
    }

    @Override
    public Paper getPaper(Integer paperId){
        return paperMapper.getPaper(paperId);
    }

    @Override
    public Paper getByLink(String paperLink){ return paperMapper.getByLink(paperLink); }

    @Override
    public int deletePaper(Integer paperId){
        return paperMapper.deletePaper(paperId);
    }

    @Override
    public int updatePaper(Paper paper){
        return paperMapper.updatePaper(paper);
    }

    @Override
    public Page<Paper> list(String type, String cond, int sort) {
        Page<Paper> list = paperMapper.list(type, cond, sort);
        for (Paper paper : list) {
            paper.setPaperAuthor(paperMapper.getPaperAuthor(paper.getPaperId()));
            paper.setPaperCitation(paperMapper.getPaperCitation(paper.getPaperId()));
            paper.setPaperRd(paperMapper.getPaperRd(paper.getPaperId()));
            paper.setPaperAdditionalFile(paperMapper.getPaperAdditionalFile(paper.getPaperId()));
        }
        return list;
    }
}

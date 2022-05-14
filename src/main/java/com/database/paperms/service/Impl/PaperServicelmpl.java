package com.database.paperms.service.Impl;

import com.database.paperms.entity.Paper;
import com.database.paperms.mapper.PaperMapper;
import com.database.paperms.service.PaperService;
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
}

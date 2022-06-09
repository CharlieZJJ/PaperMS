package com.database.paperms.service.Impl;

import com.database.paperms.entity.Paper;
import com.database.paperms.entity.vo.AdvancedSearchValue;
import com.database.paperms.entity.vo.PageHelper;
import com.database.paperms.entity.vo.PaperVO;
import com.database.paperms.mapper.PaperMapper;
import com.database.paperms.service.PaperService;
import com.database.paperms.utils.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaperServicelmpl implements PaperService {
    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private CopyUtil copyUtil;

    @Override
    public int savePaper(Paper paper) {
        return paperMapper.insertPaper(paper);
    }

    @Override
    public Paper getPaper(Integer paperId) {
        return paperMapper.getPaper(paperId);
    }

    @Override
    public Paper getByLink(String paperLink) {
        return paperMapper.getByLink(paperLink);
    }

    @Override
    public int deletePaper(Integer paperId) {
        return paperMapper.deletePaper(paperId);
    }

    @Override
    public int updatePaper(Paper paper) {
        return paperMapper.updatePaper(paper);
    }

    @Override
    public PageHelper<PaperVO> list(String type, String cond, int sort, int pageSize, int pageNo) {
        List<Paper> list = paperMapper.list(type, cond, sort);
        return getPaperVOPageHelper(pageSize, pageNo, list);
    }

    @Override
    public PageHelper<PaperVO> advanced_list(AdvancedSearchValue value, int pageSize, int pageNo, int sort) throws SQLException {
        List<Paper> papers = null;
        try {
            papers = paperMapper.advanced_list(value, pageSize, pageNo, sort);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return getPaperVOPageHelper(pageSize,pageNo,papers);
    }

    @Override
    public PageHelper<PaperVO> getByAccount(String account, int pageSize, int pageNo, int sort) {
        List<Paper> list = paperMapper.getPaperByAccount(account, sort);
        return getPaperVOPageHelper(pageSize, pageNo, list);
    }

    private PageHelper<PaperVO> getPaperVOPageHelper(int pageSize, int pageNo, List<Paper> list) {
        int size = list.size();
        int cur = (pageNo - 1) * pageSize;
        int len = Math.min(cur + pageSize, size);
        PageHelper<PaperVO> paperHelper = new PageHelper<>();
        ArrayList<PaperVO> paperVOs = new ArrayList<>();
        if (cur < len) {
            List<Paper> papers = list.subList(cur, len);
            for (Paper paper : papers) {
                paper.setPaperAuthor(paperMapper.getPaperAuthor(paper.getPaperId()));
                paper.setPaperCitation(paperMapper.getPaperCitation(paper.getPaperId()));
                paperVOs.add(copyUtil.fromPaper(paper));
            }
            paperHelper.setData(paperVOs);
        } else
            paperHelper.setData(null);
        paperHelper.setTotal(size);
        paperHelper.setPageNo(pageNo);
        paperHelper.setPageSize(pageSize);
        return paperHelper;
    }
}

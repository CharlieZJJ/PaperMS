package com.database.paperms.service.Impl;

import com.database.paperms.entity.FileEntity;
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
import java.util.Date;
import java.util.List;

@Service
public class PaperServicelmpl implements PaperService {
    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private CopyUtil copyUtil;

    @Override
    public int savePaper(Paper paper) {
        Date publishTime = new Date();
        paper.setPaperPublishTime(publishTime);
        paperMapper.insertPaper(paper);
        Integer paperId = paper.getPaperId();
        List<String> rdlist = paper.getPaperRd();
        List<String> authorlist = paper.getPaperAuthor();
        List<Integer> citationlist = paper.getPaperCitation();
        List<FileEntity> fileList = paper.getPaperAdditionalFile();
        for (int i = 0; i < rdlist.size(); i++) {
            String rdId = rdlist.get(i);
            paperMapper.insertPaperRd(paperId, rdId);
        }
        for (int i = 0; i < authorlist.size(); i++) {
            String authorName = authorlist.get(i);
            paperMapper.insertPaperAuthor(paperId, authorName);
        }
        for (int i = 0; i < citationlist.size(); i++) {
            Integer citationId = citationlist.get(i);
            paperMapper.insertPaperCitation(paperId, citationId);
        }
        for (int i = 0; i < fileList.size(); i++) {
            FileEntity file = fileList.get(i);
            String filePath = file.getPath();
            String fileName = file.getFileName();
            Double fileSize = file.getFileSize();
            paperMapper.insertPaperAdditionalFile(paperId, filePath, fileName, fileSize);
        }
        return 1;
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
        paperMapper.deletePaperRd(paperId);
        paperMapper.deletePaperAuthor(paperId);
        paperMapper.deletePaperCitation(paperId);
        paperMapper.deletePaperAdditionalFile(paperId);
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
    public PageHelper<PaperVO> advanced_list(AdvancedSearchValue value, int pageSize, int pageNo, int sort) throws Exception {
        List<Paper> papers = null;
        try {
            papers = paperMapper.advanced_list(value, pageSize, pageNo, sort);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return getPaperVOPageHelper(pageSize, pageNo, papers);
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

    @Override
    public PageHelper<PaperVO> getByRd(int pageSize, int pageNo, String rd) {
        List<Paper> list = paperMapper.getByRd(rd);
        return getPaperVOPageHelper(pageSize, pageNo, list);
    }
}

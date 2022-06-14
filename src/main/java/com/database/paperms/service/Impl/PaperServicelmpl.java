package com.database.paperms.service.Impl;

import cn.hutool.core.date.DateException;
import cn.hutool.core.date.DateUtil;
import com.database.paperms.entity.FileEntity;
import com.database.paperms.entity.Paper;
import com.database.paperms.entity.UserNote;
import com.database.paperms.entity.dto.PaperDTO;
import com.database.paperms.entity.vo.*;
import com.database.paperms.mapper.PaperMapper;
import com.database.paperms.mapper.UserNoteMapper;
import com.database.paperms.service.PaperService;
import com.database.paperms.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PaperServicelmpl implements PaperService {
    @Resource
    private PaperMapper paperMapper;

    @Resource
    private CopyUtil copyUtil;

    @Resource
    private UserNoteMapper userNoteMapper;

    @Transactional
    @Override
    public int savePaper(PaperDTO paperDTO) {
        Paper paper = null;
        try {
            paper = copyUtil.fromDTO(paperDTO);
        } catch (DateException e) {
            return -1;
        }
        int i = paperMapper.insertPaper(paper);
        Integer paperId = paper.getPaperId();
        List<String> rdlist = paper.getPaperRd();
        List<String> authorlist = paper.getPaperAuthor();
        List<Integer> citationlist = paper.getPaperCitation();
        List<FileEntity> fileList = paper.getPaperAdditionalFile();
        rdlist.forEach(s -> paperMapper.insertPaperRd(paperId, s));
        authorlist.forEach(s -> paperMapper.insertPaperAuthor(paperId, s));
        citationlist.forEach(id -> paperMapper.insertPaperCitation(paperId, id));
        for (FileEntity file : fileList) {
            String filePath = file.getPath();
            String fileName = file.getFileName();
            Double fileSize = file.getFileSize();
            paperMapper.insertPaperAdditionalFile(paperId, filePath, fileName, fileSize);
        }
        UserNote userNote = new UserNote(paperDTO.getPaperPublisherId(), paper.getPaperId(), paperDTO.getPaperNote(), new Date());
        userNoteMapper.insertUserNote(userNote);
        return 0;
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
    public Integer getCitationIdByLink(String citationLink) {
        return paperMapper.getCitationIdByLink(citationLink);
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
    public PageHelper<PaperVO> getByRd(int pageSize, int pageNo, String rdId) {
        List<Paper> list = paperMapper.getByRd(rdId);
        return getPaperVOPageHelper(pageSize, pageNo, list);
    }

    @Override
    public Data count(int timeRange, int userId) {
        List<rdCount> rdCounts = paperMapper.countRd(userId);
        int i = paperMapper.countByUserId(userId);
        int withRange = paperMapper.countByUserIdWithRange(DateUtil.offsetDay(new Date(), -timeRange), userId);
        return new Data(i, rdCounts, withRange, timeRange);
    }
}

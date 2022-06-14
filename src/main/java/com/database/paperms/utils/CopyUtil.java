package com.database.paperms.utils;

import cn.hutool.core.date.DateException;
import cn.hutool.core.date.DateUtil;
import com.database.paperms.entity.Paper;
import com.database.paperms.entity.SmallPaper;
import com.database.paperms.entity.dto.PaperDTO;
import com.database.paperms.entity.type.Impl.PaperType;
import com.database.paperms.entity.vo.PaperVO;
import com.database.paperms.mapper.PaperMapper;
import com.database.paperms.mapper.ResearchDirectionMapper;
import com.database.paperms.mapper.UserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CopyUtil {

    @Resource
    private UserMapper userMapper;

    @Resource
    private PaperMapper paperMapper;

    @Resource
    private ResearchDirectionMapper researchDirectionMapper;

    public PaperVO fromPaper(Paper paper) {
        Integer paperId = paper.getPaperId();
        PaperVO paperVO = new PaperVO();
        paperVO.setPaperId(paperId);
        paperVO.setPaperTitle(paper.getPaperTitle());
        paperVO.setPaperMeeting(paper.getPaperMeeting());
        paperVO.setPaperDate(paper.getPaperDate());
        paperVO.setPaperSummary(paper.getPaperSummary());
        paperVO.setPaperLink(paper.getPaperLink());
        paperVO.setPaperType(paper.getPaperType().getValue());
        paperVO.setPaperPublisher(userMapper.getUserById(paper.getPaperPublisherId()));
        paperVO.setPaperPublishTime(paper.getPaperPublishTime());
        paperVO.setPaperAdditionalFile(paperMapper.getPaperAdditionalFile(paperId));
        paperVO.setPaperAuthor(paperMapper.getPaperAuthor(paperId));
        List<Integer> paperCitations = paper.getPaperCitation();
        if (!paperCitations.isEmpty()) {
            List<SmallPaper> smallPapers = paperMapper.getSmallPaper(paper.getPaperCitation());
            for (SmallPaper smallPaper : smallPapers)
                smallPaper.setPaperAuthor(paperMapper.getPaperAuthor(smallPaper.getPaperId()));
            paperVO.setPaperCitation(smallPapers);
        }
        paperVO.setPaperRd(paperMapper.getPaperRd(paperId));
        paperVO.setPaperAuthor(paper.getPaperAuthor());
        return paperVO;
    }

    public Paper fromDTO(PaperDTO paperDTO) throws DateException {
        Paper paper = new Paper();
        paper.setPaperTitle(paperDTO.getPaperTitle());
        paper.setPaperMeeting(paperDTO.getPaperMeeting());
        try {
            paper.setPaperDate(DateUtil.parse(paperDTO.getPaperDate(), "yyyy-MM-dd"));
        } catch (DateException e) {
            throw new DateException(e);
        }
        paper.setPaperSummary(paperDTO.getPaperSummary());
        paper.setPaperLink(paperDTO.getPaperLink());
        paper.setPaperType(PaperType.getByCode(paperDTO.getPaperType()));
        paper.setPaperPublisherId(paperDTO.getPaperPublisherId());
        paper.setPaperPublishTime(new Date());
        paper.setPaperAdditionalFile(paperDTO.getPaperAdditionalFile());
        paper.setPaperAuthor(paperDTO.getPaperAuthor());
        paper.setPaperCitation(paperDTO.getPaperCitation());
        List<String> list = new ArrayList<>();
        List<List<String>> paperRd = paperDTO.getPaperRd();
        paperRd.forEach(strings -> list.add(strings.get(strings.size() - 1)));
        paper.setPaperRd(list);
        return paper;
    }

}

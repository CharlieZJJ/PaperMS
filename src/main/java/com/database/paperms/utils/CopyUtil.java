package com.database.paperms.utils;

import com.database.paperms.entity.Paper;
import com.database.paperms.entity.SmallPaper;
import com.database.paperms.entity.vo.PaperVO;
import com.database.paperms.mapper.PaperMapper;
import com.database.paperms.mapper.UserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class CopyUtil {

    @Resource
    private UserMapper userMapper;

    @Resource
    private PaperMapper paperMapper;

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

}

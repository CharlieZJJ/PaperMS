package com.database.paperms.entity.vo;

import com.database.paperms.entity.FileEntity;
import com.database.paperms.entity.ResearchDirection;
import com.database.paperms.entity.SmallPaper;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PaperVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer paperId;
    private String paperTitle;
    private String paperMeeting;
    private Date paperDate; //数据库中为Date
    private String paperSummary;
    private String paperLink;
    private String paperType;
    private UserVO paperPublisher;
    private Date paperPublishTime; //数据库中为Datetime
    private List<FileEntity> paperAdditionalFile;
    private List<String> paperAuthor;
    private List<SmallPaper> paperCitation;
    private List<ResearchDirection> paperRd;

    public PaperVO(Integer paperId, String paperTitle, String paperMeeting, Date paperDate, String paperSummary, String paperLink, String paperType, UserVO paperPublisher, Date paperPublishTime, List<FileEntity> paperAdditionalFile, List<String> paperAuthor, List<SmallPaper> paperCitation, List<ResearchDirection> paperRd) {
        this.paperId = paperId;
        this.paperTitle = paperTitle;
        this.paperMeeting = paperMeeting;
        this.paperDate = paperDate;
        this.paperSummary = paperSummary;
        this.paperLink = paperLink;
        this.paperType = paperType;
        this.paperPublisher = paperPublisher;
        this.paperPublishTime = paperPublishTime;
        this.paperAdditionalFile = paperAdditionalFile;
        this.paperAuthor = paperAuthor;
        this.paperCitation = paperCitation;
        this.paperRd = paperRd;
    }

    public PaperVO() {
    }

    public UserVO getPaperPublisher() {
        return paperPublisher;
    }

    public void setPaperPublisher(UserVO paperPublisher) {
        this.paperPublisher = paperPublisher;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public String getPaperMeeting() {
        return paperMeeting;
    }

    public void setPaperMeeting(String paperMeeting) {
        this.paperMeeting = paperMeeting;
    }

    public Date getPaperDate() {
        return paperDate;
    }

    public void setPaperDate(Date paperDate) {
        this.paperDate = paperDate;
    }

    public String getPaperSummary() {
        return paperSummary;
    }

    public void setPaperSummary(String paperSummary) {
        this.paperSummary = paperSummary;
    }

    public String getPaperLink() {
        return paperLink;
    }

    public void setPaperLink(String paperLink) {
        this.paperLink = paperLink;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }


    public Date getPaperPublishTime() {
        return paperPublishTime;
    }

    public void setPaperPublishTime(Date paperPublishTime) {
        this.paperPublishTime = paperPublishTime;
    }

    public List<FileEntity> getPaperAdditionalFile() {
        return paperAdditionalFile;
    }

    public void setPaperAdditionalFile(List<FileEntity> paperAdditionalFile) {
        this.paperAdditionalFile = paperAdditionalFile;
    }

    public List<String> getPaperAuthor() {
        return paperAuthor;
    }

    public void setPaperAuthor(List<String> paperAuthor) {
        this.paperAuthor = paperAuthor;
    }

    public List<SmallPaper> getPaperCitation() {
        return paperCitation;
    }

    public void setPaperCitation(List<SmallPaper> paperCitation) {
        this.paperCitation = paperCitation;
    }

    public List<ResearchDirection> getPaperRd() {
        return paperRd;
    }

    public void setPaperRd(List<ResearchDirection> paperRd) {
        this.paperRd = paperRd;
    }

}

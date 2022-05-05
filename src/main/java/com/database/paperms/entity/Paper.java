package com.database.paperms.entity;

import com.database.paperms.entity.type.Impl.PaperType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ClassName: com.database.paperms.entity.Paper
 * Created by zjj
 * Date: 2022-05-04 22:51
 */
public class Paper implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer paperId;
    private String paperTitle;
    private String paperMeeting;
    private Date paperDate; //数据库中为Date
    private String paperSummary;
    private String paperLink;
    private PaperType paperType;
    private Integer paperPublisherId;
    private Date paperPublishTime; //数据库中为Datetime
    private List<String> paperAdditionalFile;
    private List<String> paperAuthor;
    private List<Integer> paperCitation;
    private List<Long> paperRd;

    public Paper() {
    }

    public Paper(Integer paperId, String paperTitle, String paperMeeting, Date paperDate, String paperSummary, String paperLink, PaperType paperType, Integer paperPublisherId, Date paperPublishTime, List<String> paperAdditionalFile, List<String> paperAuthor, List<Integer> paperCitation, List<Long> paperRd) {
        this.paperId = paperId;
        this.paperTitle = paperTitle;
        this.paperMeeting = paperMeeting;
        this.paperDate = paperDate;
        this.paperSummary = paperSummary;
        this.paperLink = paperLink;
        this.paperType = paperType;
        this.paperPublisherId = paperPublisherId;
        this.paperPublishTime = paperPublishTime;
        this.paperAdditionalFile = paperAdditionalFile;
        this.paperAuthor = paperAuthor;
        this.paperCitation = paperCitation;
        this.paperRd = paperRd;
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

    public PaperType getPaperType() {
        return paperType;
    }

    public void setPaperType(PaperType paperType) {
        this.paperType = paperType;
    }

    public Integer getPaperPublisherId() {
        return paperPublisherId;
    }

    public void setPaperPublisherId(Integer paperPublisherId) {
        this.paperPublisherId = paperPublisherId;
    }

    public Date getPaperPublishTime() {
        return paperPublishTime;
    }

    public void setPaperPublishTime(Date paperPublishTime) {
        this.paperPublishTime = paperPublishTime;
    }

    public List<String> getPaperAdditionalFile() {
        return paperAdditionalFile;
    }

    public void setPaperAdditionalFile(List<String> paperAdditionalFile) {
        this.paperAdditionalFile = paperAdditionalFile;
    }

    public List<String> getPaperAuthor() {
        return paperAuthor;
    }

    public void setPaperAuthor(List<String> paperAuthor) {
        this.paperAuthor = paperAuthor;
    }

    public List<Integer> getPaperCitation() {
        return paperCitation;
    }

    public void setPaperCitation(List<Integer> paperCitation) {
        this.paperCitation = paperCitation;
    }

    public List<Long> getPaperRd() {
        return paperRd;
    }

    public void setPaperRd(List<Long> paperRd) {
        this.paperRd = paperRd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paper)) return false;

        Paper paper = (Paper) o;

        if (!paperId.equals(paper.paperId)) return false;
        if (!paperTitle.equals(paper.paperTitle)) return false;
        if (!paperMeeting.equals(paper.paperMeeting)) return false;
        if (!paperDate.equals(paper.paperDate)) return false;
        if (!paperSummary.equals(paper.paperSummary)) return false;
        if (!paperLink.equals(paper.paperLink)) return false;
        if (paperType != paper.paperType) return false;
        if (!paperPublisherId.equals(paper.paperPublisherId)) return false;
        if (!paperPublishTime.equals(paper.paperPublishTime)) return false;
        if (paperAdditionalFile != null ? !paperAdditionalFile.equals(paper.paperAdditionalFile) : paper.paperAdditionalFile != null)
            return false;
        if (!paperAuthor.equals(paper.paperAuthor)) return false;
        if (paperCitation != null ? !paperCitation.equals(paper.paperCitation) : paper.paperCitation != null)
            return false;
        return paperRd.equals(paper.paperRd);
    }

    @Override
    public int hashCode() {
        int result = paperId.hashCode();
        result = 31 * result + paperTitle.hashCode();
        result = 31 * result + paperMeeting.hashCode();
        result = 31 * result + paperDate.hashCode();
        result = 31 * result + paperSummary.hashCode();
        result = 31 * result + paperLink.hashCode();
        result = 31 * result + paperType.hashCode();
        result = 31 * result + paperPublisherId.hashCode();
        result = 31 * result + paperPublishTime.hashCode();
        result = 31 * result + (paperAdditionalFile != null ? paperAdditionalFile.hashCode() : 0);
        result = 31 * result + paperAuthor.hashCode();
        result = 31 * result + (paperCitation != null ? paperCitation.hashCode() : 0);
        result = 31 * result + paperRd.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "paperId=" + paperId +
                ", paperTitle='" + paperTitle + '\'' +
                ", paperMeeting='" + paperMeeting + '\'' +
                ", paperDate=" + paperDate +
                ", paperSummary='" + paperSummary + '\'' +
                ", paperLink='" + paperLink + '\'' +
                ", paperType=" + paperType +
                ", paperPublisherId=" + paperPublisherId +
                ", paperPublishTime=" + paperPublishTime +
                ", paperAdditionalFile=" + paperAdditionalFile +
                ", paperAuthor=" + paperAuthor +
                ", paperCitation=" + paperCitation +
                ", paperRd=" + paperRd +
                '}';
    }
}

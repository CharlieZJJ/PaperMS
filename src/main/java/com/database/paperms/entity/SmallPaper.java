package com.database.paperms.entity;

import java.util.List;

public class SmallPaper {
    private Integer paperId;
    private String paperTitle;
    private List<String> paperAuthor;

    public SmallPaper(Integer paperId, String paperTitle, List<String> paperAuthor) {
        this.paperId = paperId;
        this.paperTitle = paperTitle;
        this.paperAuthor = paperAuthor;
    }

    public SmallPaper() {
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

    public List<String> getPaperAuthor() {
        return paperAuthor;
    }

    public void setPaperAuthor(List<String> paperAuthor) {
        this.paperAuthor = paperAuthor;
    }
}
package com.database.paperms.entity.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AdvancedSearchValue implements Serializable {

    private List<String> info;

    private List<String> paperType;

    private List<Integer> paperTypeInt;

    private List<String> relation;

    private List<String> searchType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private List<Date> timeRange;

    public AdvancedSearchValue(List<String> info, List<String> paperType, List<Integer> paperTypeInt, List<String> relation, List<String> searchType, List<Date> timeRange) {
        this.info = info;
        this.paperType = paperType;
        this.paperTypeInt = paperTypeInt;
        this.relation = relation;
        this.searchType = searchType;
        this.timeRange = timeRange;
    }

    public AdvancedSearchValue(List<String> info, List<String> paperType, List<String> relation, List<String> searchType, List<Date> timeRange) {
        this.info = info;
        this.paperType = paperType;
        this.relation = relation;
        this.searchType = searchType;
        this.timeRange = timeRange;
    }

    public AdvancedSearchValue() {
    }

    public List<String> getInfo() {
        return info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }

    public List<String> getPaperType() {
        return paperType;
    }

    public void setPaperType(List<String> paperType) {
        this.paperType = paperType;
    }

    public List<Integer> getPaperTypeInt() {
        return paperTypeInt;
    }

    public void setPaperTypeInt(List<Integer> paperTypeInt) {
        this.paperTypeInt = paperTypeInt;
    }

    public List<String> getRelation() {
        return relation;
    }

    public void setRelation(List<String> relation) {
        this.relation = relation;
    }

    public List<String> getSearchType() {
        return searchType;
    }

    public void setSearchType(List<String> searchType) {
        this.searchType = searchType;
    }

    public List<Date> getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(List<Date> timeRange) {
        this.timeRange = timeRange;
    }
}

package com.database.paperms.entity.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Data implements Serializable {

    private Integer paperCount;

    private List<rdCount> rdCount;

    private Integer paperCountWithRange;

    private Integer timeRange; //以天为单位

    public Data(Integer paperCount, List<com.database.paperms.entity.vo.rdCount> rdCount, Integer paperCountWithRange, Integer timeRange) {
        this.paperCount = paperCount;
        this.rdCount = rdCount;
        this.paperCountWithRange = paperCountWithRange;
        this.timeRange = timeRange;
    }

    public Data() {
    }

    public Integer getPaperCount() {
        return paperCount;
    }

    public void setPaperCount(Integer paperCount) {
        this.paperCount = paperCount;
    }

    public List<com.database.paperms.entity.vo.rdCount> getRdCount() {
        return rdCount;
    }

    public void setRdCount(List<com.database.paperms.entity.vo.rdCount> rdCount) {
        this.rdCount = rdCount;
    }

    public Integer getPaperCountWithRange() {
        return paperCountWithRange;
    }

    public void setPaperCountWithRange(Integer paperCountWithRange) {
        this.paperCountWithRange = paperCountWithRange;
    }

    public Integer getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(Integer timeRange) {
        this.timeRange = timeRange;
    }
}

package com.database.paperms.entity.vo;

public class rdCount {

    private String rdName;

    private Integer count;

    public rdCount(String rdName, Integer count) {
        this.rdName = rdName;
        this.count = count;
    }

    public rdCount() {
    }

    public String getRdName() {
        return rdName;
    }

    public void setRdName(String rdName) {
        this.rdName = rdName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

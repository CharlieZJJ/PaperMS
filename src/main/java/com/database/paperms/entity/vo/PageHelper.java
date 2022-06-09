package com.database.paperms.entity.vo;

import java.util.List;

public class PageHelper<T> {

    private int total;

    private int pageNo;

    private int pageSize;

    private List<T> data;


    public PageHelper(int total, int pageNo, int pageSize, List<T> data) {
        this.total = total;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.data = data;
    }

    public PageHelper(List<T> data) {
        this.data = data;
    }

    public PageHelper() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

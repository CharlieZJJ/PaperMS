package com.database.paperms.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageHelper<T> {

    private int total;

    private int pageNo;

    private int pageSize;

    private List<T> data;

    public PageHelper(List<T> data) {
        this.data = data;
    }

}

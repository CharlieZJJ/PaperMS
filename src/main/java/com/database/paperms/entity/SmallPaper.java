package com.database.paperms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmallPaper {
    private Integer paperId;

    private String paperTitle;

    private List<String> paperAuthor;
}
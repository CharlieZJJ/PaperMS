package com.database.paperms.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvancedSearchValue implements Serializable {

    private List<String> info;

    private List<String> paperType;

    private List<Integer> paperTypeInt;

    private List<String> relation;

    private List<String> searchType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private List<Date> timeRange;
}

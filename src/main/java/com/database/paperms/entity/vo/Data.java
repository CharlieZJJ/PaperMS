package com.database.paperms.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Data implements Serializable {

    private Integer paperCount;

    private List<rdCount> rdCount;

    private Integer paperCountWithRange;

    private Integer timeRange; //以天为单位

}

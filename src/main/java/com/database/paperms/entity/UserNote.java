package com.database.paperms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserNote implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer noteUserId;

    private Integer notePaperId;

    private String noteContent;

    private Date noteUpdateTime;
}

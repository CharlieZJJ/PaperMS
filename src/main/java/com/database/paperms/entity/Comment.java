package com.database.paperms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: com.database.paperms.entity.Comment
 * Created by zjj
 * Date: 2022-05-05 9:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer paperId;

    private Integer commentId;

    private Integer commentUserId;

    private String commentContent;

    private Date commentDate;
}

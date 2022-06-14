package com.database.paperms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: com.database.paperms.entity.Reply
 * Created by zjj
 * Date: 2022-05-05 9:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer commentId;

    private Integer replyId;

    private Integer replyUserId;

    private Integer replyUserToId;

    private String replyContent;

    private Date replyDate;

}

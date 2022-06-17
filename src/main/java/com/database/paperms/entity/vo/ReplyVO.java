package com.database.paperms.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyVO {

    CommentUserVO commentUser;

    String content;

    Date createDate;

    Integer id;

    CommentUserVO targetUser;

}

package com.database.paperms.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVO {

    List<ReplyVO> childrenList;

    CommentUserVO commentUser;

    String content;

    Date createDate;

    Integer id;

    CommentUserVO targetUser;

}

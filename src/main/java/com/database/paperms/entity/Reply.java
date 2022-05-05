package com.database.paperms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: com.database.paperms.entity.Reply
 * Created by zjj
 * Date: 2022-05-05 9:23
 */
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer commentId;
    private Integer replyId;
    private Integer replyUserId;
    private Integer replyUserToId;
    private String replyContent;
    private Date replyDate;

    public Reply() {
    }

    public Reply(Integer commentId, Integer replyId, Integer replyUserId, Integer replyUserToId, String replyContent, Date replyDate) {
        this.commentId = commentId;
        this.replyId = replyId;
        this.replyUserId = replyUserId;
        this.replyUserToId = replyUserToId;
        this.replyContent = replyContent;
        this.replyDate = replyDate;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Integer replyUserId) {
        this.replyUserId = replyUserId;
    }

    public Integer getReplyUserToId() {
        return replyUserToId;
    }

    public void setReplyUserToId(Integer replyUserToId) {
        this.replyUserToId = replyUserToId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reply)) return false;

        Reply reply = (Reply) o;

        if (commentId != null ? !commentId.equals(reply.commentId) : reply.commentId != null) return false;
        if (!replyId.equals(reply.replyId)) return false;
        if (replyUserId != null ? !replyUserId.equals(reply.replyUserId) : reply.replyUserId != null) return false;
        if (replyUserToId != null ? !replyUserToId.equals(reply.replyUserToId) : reply.replyUserToId != null)
            return false;
        if (!replyContent.equals(reply.replyContent)) return false;
        return replyDate.equals(reply.replyDate);
    }

    @Override
    public int hashCode() {
        int result = commentId != null ? commentId.hashCode() : 0;
        result = 31 * result + replyId.hashCode();
        result = 31 * result + (replyUserId != null ? replyUserId.hashCode() : 0);
        result = 31 * result + (replyUserToId != null ? replyUserToId.hashCode() : 0);
        result = 31 * result + replyContent.hashCode();
        result = 31 * result + replyDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "commentId=" + commentId +
                ", replyId=" + replyId +
                ", replyUserId=" + replyUserId +
                ", replyUserToId=" + replyUserToId +
                ", replyContent='" + replyContent + '\'' +
                ", replyDate=" + replyDate +
                '}';
    }
}

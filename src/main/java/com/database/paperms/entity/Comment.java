package com.database.paperms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: com.database.paperms.entity.Comment
 * Created by zjj
 * Date: 2022-05-05 9:19
 */
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer paperId;
    private Integer commentId;
    private Integer commentUserId;
    private String commentContent;
    private Date commentDate;

    public Comment() {
    }

    public Comment(Integer paperId, Integer commentId, Integer commentUserId, String commentContent, Date commentDate) {
        this.paperId = paperId;
        this.commentId = commentId;
        this.commentUserId = commentUserId;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Integer commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;

        Comment comment = (Comment) o;

        if (!paperId.equals(comment.paperId)) return false;
        if (!commentId.equals(comment.commentId)) return false;
        if (!commentUserId.equals(comment.commentUserId)) return false;
        if (!commentContent.equals(comment.commentContent)) return false;
        return commentDate.equals(comment.commentDate);
    }

    @Override
    public int hashCode() {
        int result = paperId.hashCode();
        result = 31 * result + commentId.hashCode();
        result = 31 * result + commentUserId.hashCode();
        result = 31 * result + commentContent.hashCode();
        result = 31 * result + commentDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "paperId=" + paperId +
                ", commentId=" + commentId +
                ", commentUserId=" + commentUserId +
                ", commentContent='" + commentContent + '\'' +
                ", commentDate=" + commentDate +
                '}';
    }

}

package com.database.paperms.entity;

import java.io.Serializable;
import java.util.Date;

public class UserNote implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer noteUserId;

    private Integer notePaperId;

    private String noteContent;

    private Date noteUpdateTime;

    public UserNote(Integer noteUserId, Integer notePaperId, String noteContent, Date noteUpdateTime) {
        this.noteUserId = noteUserId;
        this.notePaperId = notePaperId;
        this.noteContent = noteContent;
        this.noteUpdateTime = noteUpdateTime;
    }

    public Integer getNoteUserId() {
        return noteUserId;
    }

    public void setNoteUserId(Integer noteUserId) {
        this.noteUserId = noteUserId;
    }

    public Integer getNotePaperId() {
        return notePaperId;
    }

    public void setNotePaperId(Integer notePaperId) {
        this.notePaperId = notePaperId;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public Date getNoteUpdateTime() {
        return noteUpdateTime;
    }

    public void setNoteUpdateTime(Date noteUpdateTime) {
        this.noteUpdateTime = noteUpdateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserNote)) return false;

        UserNote userNote = (UserNote) o;

        if (!noteUserId.equals(userNote.noteUserId)) return false;
        if (!notePaperId.equals(userNote.notePaperId)) return false;
        if (!noteContent.equals(userNote.noteContent)) return false;
        return noteUpdateTime.equals(userNote.noteUpdateTime);
    }

    @Override
    public String toString() {
        return "UserNote{" +
                "noteUserId=" + noteUserId +
                ", notePaperId='" + notePaperId + '\'' +
                ", noteContent='" + noteContent + '\'' +
                ", noteUpdateTime='" + noteUpdateTime +
                '}';
    }

    @Override
    public int hashCode() {
        int result = noteUserId.hashCode();
        result = 31 * result + notePaperId.hashCode();
        result = 31 * result + noteContent.hashCode();
        result = 31 * result + noteUpdateTime.hashCode();
        return result;
    }
}

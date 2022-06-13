package com.database.paperms.service;

import com.database.paperms.entity.UserNote;

public interface UserNoteService {

    int insertUserNote(UserNote userNote);

    int deleteUserNote(Integer noteUserId,Integer notePaperId);

    UserNote getUserNote(Integer noteUserId,Integer notePaperId);

    int updateUserNote(UserNote userNote);
}

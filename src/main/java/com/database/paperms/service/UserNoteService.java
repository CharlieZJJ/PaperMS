package com.database.paperms.service;

import com.database.paperms.entity.UserNote;
import com.database.paperms.entity.vo.PageHelper;

public interface UserNoteService {

    int insertUserNote(UserNote userNote);

    int deleteUserNote(Integer noteUserId, Integer notePaperId);

    UserNote getUserNote(Integer noteUserId, Integer notePaperId);

    int updateUserNote(UserNote userNote);

    PageHelper<UserNote> listUserNote(Integer noteUserId, int pageSize, int pageNo);
}

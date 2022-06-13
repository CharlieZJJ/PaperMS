package com.database.paperms.service;

import com.database.paperms.entity.User;
import com.database.paperms.entity.UserNote;
import com.database.paperms.entity.vo.PageHelper;

import java.util.List;

public interface UserNoteService {

    int insertUserNote(UserNote userNote);

    int deleteUserNote(Integer noteUserId,Integer notePaperId);

    UserNote getUserNote(Integer noteUserId,Integer notePaperId);

    int updateUserNote(UserNote userNote);

    PageHelper<UserNote> listUserNote (Integer noteUserId, int pageSize, int pageNo);
}

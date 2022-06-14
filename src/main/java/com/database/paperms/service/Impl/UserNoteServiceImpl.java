package com.database.paperms.service.Impl;

import com.database.paperms.entity.UserNote;
import com.database.paperms.entity.vo.PageHelper;
import com.database.paperms.mapper.UserNoteMapper;
import com.database.paperms.service.UserNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserNoteServiceImpl implements UserNoteService {

    @Autowired
    private UserNoteMapper userNoteMapper;

    @Override
    public int insertUserNote(UserNote userNote) {
        Date updateTime = new Date();
        userNote.setNoteUpdateTime(updateTime);
        return userNoteMapper.insertUserNote(userNote);
    }

    @Override
    public int deleteUserNote(Integer noteUserId, Integer notePaperId) {
        return userNoteMapper.deleteUserNote(noteUserId, notePaperId);
    }

    @Override
    public UserNote getUserNote(Integer noteUserId, Integer notePaperId) {
        return userNoteMapper.getUserNote(noteUserId, notePaperId);
    }

    @Override
    public int updateUserNote(UserNote userNote) {
        Date updateTime = new Date();
        userNote.setNoteUpdateTime(updateTime);
        return userNoteMapper.updateUserNote(userNote);
    }

    @Override
    public PageHelper<UserNote> listUserNote(Integer noteUserId, int pageSize, int pageNo) {
        List<UserNote> list = userNoteMapper.listUserNote(noteUserId, (pageNo - 1) * pageSize, pageSize);
        PageHelper<UserNote> userPageHelper = new PageHelper<>(list);
        userPageHelper.setTotal(userNoteMapper.count());
        userPageHelper.setPageSize(pageSize);
        userPageHelper.setPageNo(pageNo);
        return userPageHelper;
    }
}

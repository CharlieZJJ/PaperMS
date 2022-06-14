package com.database.paperms.mapper;

import com.database.paperms.entity.UserNote;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserNoteMapper {

    int insertUserNote(UserNote userNote);

    int deleteUserNote(Integer noteUserId, Integer notePaperId);

    UserNote getUserNote(Integer noteUserId, Integer notePaperId);

    List<UserNote> listUserNote(Integer noteUserId, int offset, int pageSize);

    int updateUserNote(UserNote userNote);

    int count();

}

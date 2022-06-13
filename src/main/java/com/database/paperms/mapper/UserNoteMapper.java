package com.database.paperms.mapper;

import com.database.paperms.entity.Reply;
import com.database.paperms.entity.UserNote;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserNoteMapper {

    int insertUserNote(UserNote userNote);

    int deleteUserNote(Integer noteUserId,Integer notePaperId);

    UserNote getUserNote(Integer noteUserId,Integer notePaperId);

    int updateUserNote(UserNote userNote);

}

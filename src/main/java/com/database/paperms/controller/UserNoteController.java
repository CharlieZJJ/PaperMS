package com.database.paperms.controller;

import com.database.paperms.entity.UserNote;
import com.database.paperms.entity.vo.PageHelper;
import com.database.paperms.response.ResultData;
import com.database.paperms.response.ReturnCode;
import com.database.paperms.service.UserNoteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/usernote")
public class UserNoteController {

    @Resource
    private UserNoteService userNoteService;

    @PostMapping("/add")
    public ResultData add(@RequestBody UserNote userNote) {
        if (userNoteService.getUserNote(userNote.getNoteUserId(), userNote.getNotePaperId()) == null) {
            userNoteService.insertUserNote(userNote);
            return ResultData.success();
        } else {
            return ResultData.fail(ReturnCode.USED_USER_NOTE);
        }
    }

    @DeleteMapping("/delete")
    public ResultData delete(@RequestParam Integer noteUserId, @RequestParam Integer notePaperId) {
        if (userNoteService.getUserNote(noteUserId, notePaperId) != null) {
            userNoteService.deleteUserNote(noteUserId, notePaperId);
            return ResultData.success();
        } else {
            return ResultData.fail(ReturnCode.NOT_EXISTENT_USER_NOTE);
        }
    }

    @PostMapping("/update")
    public ResultData update(@RequestBody UserNote userNote) {
        if (userNoteService.getUserNote(userNote.getNoteUserId(), userNote.getNotePaperId()) != null) {
            userNoteService.updateUserNote(userNote);
            return ResultData.success();
        } else {
            return ResultData.fail(ReturnCode.NOT_EXISTENT_USER_NOTE);
        }
    }

    @PutMapping("/list")
    public ResultData list(@RequestParam Integer noteUserId, @RequestParam int pageSize, @RequestParam int pageNo) {
        PageHelper<UserNote> list = userNoteService.listUserNote(noteUserId, pageSize, pageNo);
        return ResultData.success(list);
    }

}

package com.database.paperms.controller.admin;

import com.database.paperms.entity.User;
import com.database.paperms.entity.vo.Data;
import com.database.paperms.entity.vo.PageHelper;
import com.database.paperms.response.ResultData;
import com.database.paperms.service.PaperService;
import com.database.paperms.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Resource
    private UserService userService;

    @Resource
    private PaperService paperService;

    @PutMapping("/upgrade/{id}")
    public ResultData upgrade(@PathVariable int id) {
        if (userService.upgrade(id))
            return ResultData.success(id);
        else return ResultData.fail(-1, "更新失败");
    }

    @PutMapping("/delete/{id}")
    public ResultData delete(@PathVariable int id) {
        if (userService.delete(id))
            return ResultData.success(id);
        else return ResultData.fail(-1, "更新失败");
    }

    @PutMapping("/list")
    public ResultData list(@RequestParam int pageSize, @RequestParam int pageNo) {
        PageHelper<User> list = userService.list(pageSize, pageNo);
        return ResultData.success(list);
    }

    @GetMapping("/statistics/{user_id}")
    public ResultData statistics(@RequestParam(defaultValue = "0")Integer timeRange, @PathVariable Integer user_id){
        Data count = paperService.count(timeRange, user_id);
        return ResultData.success(count);
    }

}

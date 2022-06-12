package com.database.paperms.controller.admin;

import com.database.paperms.entity.User;
import com.database.paperms.entity.vo.PageHelper;
import com.database.paperms.response.ResultData;
import com.database.paperms.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Resource
    private UserService userService;

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

}

package com.database.paperms.controller;

import com.database.paperms.entity.User;
import com.database.paperms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: com.database.paperms.controller.UserController
 * Created by zjj
 * Date: 2022-05-05 15:24
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable int id){
        User user = userService.getUserById(id);
        return user;
    }

}

package com.database.paperms.service.Impl;

import com.database.paperms.entity.User;
import com.database.paperms.mapper.UserMapper;
import com.database.paperms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: com.database.paperms.service.Impl.UserServiceImpl
 * Created by zjj
 * Date: 2022-05-05 15:22
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userMapper.getById(id);
    }
}

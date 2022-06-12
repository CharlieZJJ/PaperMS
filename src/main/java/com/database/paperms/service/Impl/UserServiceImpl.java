package com.database.paperms.service.Impl;

import com.database.paperms.entity.User;
import com.database.paperms.entity.vo.PageHelper;
import com.database.paperms.mapper.UserMapper;
import com.database.paperms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: com.database.paperms.service.Impl.UserServiceImpl
 * Created by zjj
 * Date: 2022-05-05 15:22
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Resource
    private Pbkdf2PasswordEncoder passwordEncoder;

    @Override
    public User getUserById(int id) {
        return userMapper.getById(id);
    }

    @Override
    public int save(User user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        return userMapper.insertUser(user);
    }

    @Override
    public User login(String account) {
        User user = userMapper.getByAccount(account);
        return user;
    }

    @Override
    public boolean accountExist(String account) {
        return userMapper.testAccount(account) != null;
    }

    @Override
    public boolean upgrade(Integer userId) {
        return userMapper.upgrade(userId) == 1;
    }

    @Override
    public boolean delete(Integer userId) {
        return userMapper.delete(userId) == 1;
    }

    @Override
    public PageHelper<User> list(int pageSize, int pageNo) {
        List<User> list = userMapper.list((pageNo - 1) * pageSize, pageSize);
        PageHelper<User> userPageHelper = new PageHelper<>(list);
        userPageHelper.setTotal(userMapper.count());
        userPageHelper.setPageSize(pageSize);
        userPageHelper.setPageNo(pageNo);
        return userPageHelper;
    }
}

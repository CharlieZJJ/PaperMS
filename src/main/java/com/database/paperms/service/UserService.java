package com.database.paperms.service;

import com.database.paperms.entity.User;
import com.database.paperms.entity.vo.PageHelper;

/**
 * ClassName: com.database.paperms.service.UserService
 * Created by zjj
 * Date: 2022-05-05 15:22
 */
public interface UserService {
    User getUserById(int id);

    Integer getIdByAccount(String account);

    int save(User user);

    User login(String userAccount);

    boolean accountExist(String account);

    boolean upgrade(Integer userId);

    boolean delete(Integer userId);

    PageHelper<User> list(int pageSize, int pageNo);

}

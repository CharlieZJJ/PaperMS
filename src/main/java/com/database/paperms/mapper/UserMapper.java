package com.database.paperms.mapper;

import com.database.paperms.entity.User;
import com.database.paperms.entity.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: com.database.paperms.mapper.UserMapper
 * Created by zjj
 * Date: 2022-05-05 11:53
 */
@Mapper
public interface UserMapper {

    User getById(int id);

    int insertUser(User user);

    User getByAccount(String account);

    Integer testAccount(String userAccount);

    UserVO getUserById(Integer userId);

    int upgrade(Integer userId);

    int delete(Integer userId);

    List<User> list(int offset, int pageSize);

    int count();

}
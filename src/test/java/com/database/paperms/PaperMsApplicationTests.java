package com.database.paperms;

import cn.hutool.core.util.RandomUtil;
import com.database.paperms.entity.User;
import com.database.paperms.service.UserService;
import com.database.paperms.utils.MailUtil;
import com.database.paperms.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
class PaperMsApplicationTests {

    @Autowired
    private MailUtil mailUtil;
    @Autowired
    private RedisUtil redisUtil;
    @Resource
    private Pbkdf2PasswordEncoder passwordEncoder;
    @Resource
    private UserService userService;

    @Test
    void contextLoads() {
        System.out.println(passwordEncoder.encode("123456").length());
    }

    @Test
    void test(){

    }

}

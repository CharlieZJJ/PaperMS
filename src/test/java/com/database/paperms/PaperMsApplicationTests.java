package com.database.paperms;

import com.database.paperms.entity.SmallPaper;
import com.database.paperms.mapper.PaperMapper;
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
import java.util.ArrayList;
import java.util.List;

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
    @Resource
    private PaperMapper paperMapper;

    @Test
    void contextLoads() {
        System.out.println(passwordEncoder.encode("123456").length());
    }

    @Test
    void test() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(6);
        List<SmallPaper> smallPaper = paperMapper.getSmallPaper(list);
        System.out.println(smallPaper);
    }



}

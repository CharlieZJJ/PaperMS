package com.database.paperms;

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
        Integer hello = paperMapper.getIdByLink("https://kns.cnki.net/kcms/detail/detail.aspx?dbcode=IPFD&dbname=IPFDLAST2017&filename=GCKZ201607001326&uniplatform=NZKPT&v=DXd3ASmqxgFHacmBAAC0I3ch75iMZPn34Mbgc15nMcgPZ6MAKTztn40MWzR0W1YaBsgQ57-gQ3w%3d");
        if (hello == null) System.out.println("null");
        else System.out.println(hello);
    }

}

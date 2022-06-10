package com.database.paperms.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * ClassName: com.database.paperms.utils.MailUtil
 * Created by zjj
 * Date: 2022-05-06 9:59
 */
@Component
public class MailUtil {
    public static final String TEXT = "这是PaperMS系统注册验证码，请您在五分钟以内输入，否则失效。\n\n";
    @Value("${spring.mail.username}")
    private String from;
    @Value("${spring.mail.nickname}")
    private String nickname;
    @Resource
    private JavaMailSender mailSender;

    public void sendSimpleMail(String to, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(nickname + '<' + from + '>');
        message.setTo(to);
        message.setSubject("PaperMS验证码");
        message.setText(TEXT + code);
        mailSender.send(message);
    }
}
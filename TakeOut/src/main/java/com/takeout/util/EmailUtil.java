package com.takeout.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Repository
public class EmailUtil
{
    @Value("${spring.mail.from}")
    private String sender;

    private JavaMailSender javaMailSender;
    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendSimple(String email, String text, String subject)
    {
        // 简单邮件消息
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom(sender);
        javaMailSender.send(simpleMailMessage);
    }

    public void sendHTML(String email,String html,String subject) throws MessagingException
    {
        // 创建一个有内容类型的消息
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // 消息内容设置助手
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        // 消息内容
        mimeMessageHelper.setText(html,true); // 设置为html类型
        // 消息主题
        mimeMessageHelper.setSubject(subject);
        // 接收者
        mimeMessageHelper.setTo(email);
        // 发送者
        mimeMessageHelper.setFrom(sender);
        // 发送
        javaMailSender.send(mimeMessage);
    }
}

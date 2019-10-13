package com.github.wangfeng.springboot.mail.service.impl;

import com.github.wangfeng.springboot.mail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MailServiceImplTest {
    @Autowired
    private MailService mailService;

    /**
     * 测试发送文本邮件
     */
    @Test
    public void sendmail() {
        mailService.sendSimpleMail("wangfengbabe@163.com", "主题：你好普通邮件", "内容：第一封邮件");
    }

    @Test
    public void sendmailHtml() {
        mailService.sendHtmlMail("wangfengbabe@163.com", "主题：你好html邮件", "<h1>内容：第一封html邮件</h1>");
    }

    @Test
    public void sendMailAttachment() {
        mailService.sendAttachmentsMail("wangfengbabe@163.com", "主题：你好普通邮件1", "内容：第一封邮件", "/Users/wangfeng/Documents/books/hello.txt");
    }

    @Test
    public void sendMailWithTemplate() throws MessagingException {
        String to = "wangfengbabe@163.com";
        String subject = "thymeleaf 模板";
        Map<String, Object> contentVaraibles = new HashMap<>();
        contentVaraibles.put("message", "hello");
        String templatePath = "mail/mailTemplate";
        mailService.sendMailWitTemplate(to, subject, contentVaraibles, templatePath);
    }

}
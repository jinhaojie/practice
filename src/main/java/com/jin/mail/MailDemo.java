package com.jin.mail;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailDemo {

    public static void main(String[] args) throws Exception {
        /**
         * 1.配置发件人邮箱信息以及创建一个Java 配置类存放SMTP服务器地址等参数。
         */
        String sendEmailAccount = "cupertino1992@163.com";                            // 发件人邮箱
        String sendEmailPassword = "09318341679j";                                      // 发件人密码
        String sendEmailSMTPHost = "smtp.163.com";                         // 发件人邮箱的 SMTP 服务器地址, 此处为Outlook邮箱的SMTP服务器
        String receiveMailAccount = "haojie.jin@weimob.com";                              // 收件人邮箱
        Properties props = new Properties();                                        // 使用Java配置类进行配置
        props.setProperty("mail.transport.protocol", "smtp");                       // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", sendEmailSMTPHost);                     // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");                                // 需要请求认证
        final String smtpPort = "465";                                              // 默认端口号设置为587，也可以设置为465，具体取决于SMTP服务器要求的端口号
//        props.setProperty("mail.smtp.port",smtpPort );
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.starttls.enable", "true");
//        props.setProperty("mail.smtp.socketFactory.port", smtpPort );

        /**
         * 2.创建一个同邮件服务器交互的session
         */
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);                                  // 1. 创建一封邮件
        message.setFrom(new InternetAddress(sendEmailAccount, "cupertino1992@163.com", "UTF-8"));  // 2. From: 发件人
//        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount, "574700719@qq.com", "UTF-8"));        // 3. To: 收件人
        message.setSubject("交易监控", "UTF-8");                                                 // 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
        message.setContent("交易监控文件", "text/html;charset=UTF-8"); // 5. Content: 邮件正文
        message.setSentDate(new Date());                                                 // 6. 设置邮件发件时间
        message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("cupertino1992@163.com"));
        message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("574700719@qq.com"));
        message.saveChanges();                                                           // 7. 保存设置

        /**
         * 3.创建一封格式化的邮件
         */
        Transport transport = session.getTransport();                                    // 1. 根据 Session 获取邮件传输对象
        transport.connect(sendEmailAccount, sendEmailPassword);                          // 2. 使用 邮箱账号 和 密码 连接邮件服务器
        transport.sendMessage(message, message.getAllRecipients());                      // 3. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人,
        transport.close();                                                               // 4. 关闭连接
    }


}

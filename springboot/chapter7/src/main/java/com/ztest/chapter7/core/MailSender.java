package com.ztest.chapter7.core;

import com.ztest.chapter7.entity.MailEntity;
import com.ztest.chapter7.enums.MailContentTypeEnum;
import com.ztest.chapter7.utils.PropertiesUtil;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.List;
import java.util.Properties;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/02
 * \* Time: 10:59
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:JavaMail 邮件发送主体类
 * \
 */
public class MailSender {
    //邮件实体
    private static MailEntity mail = new MailEntity();

    /**
     * 设置邮件标题
     * @param title 标题信息
     * @return
     */
    public MailSender title(String title){
        mail.setTitle(title);
        return this;
    }

    /**
     * 设置邮件内容
     *
     * @param content
     * @return
     */
    public MailSender content(String content){
        mail.setContent(content);
        return this;
    }

    /**
     * 设置邮件格式
     * @param typeEnum
     * @return
     */
    public MailSender contentType(MailContentTypeEnum typeEnum)
    {
        mail.setContentType(typeEnum.getValue());
        return this;
    }

    /**
     * 设置请求目标邮件地址
     * @param targets
     * @return
     */
    public MailSender targets(List<String> targets){
        mail.setList(targets);
        return this;
    }

    /**
     * 执行发送邮件
     * @throws Exception 失败抛出异常
     */
    public void send() throws Exception{
        //默认使用html发送
        if(mail.getContentType() == null){
            mail.setContentType(MailContentTypeEnum.HTML.getValue());
        }

        if(mail.getTitle() == null || mail.getTitle().trim().length() == 0){
            throw new Exception("邮件标题没有设置,调用title方法设置");
        }
        if(mail.getContent() == null || mail.getContent().trim().length() == 0){
            throw new Exception("邮件内容没有设置，调用content方法设置");
        }
        if(mail.getList().size() == 0){
            throw new Exception("没有接受者邮箱地址，请用targets方法设置");
        }

        //读取/resourse/mail_zh_CN.properties文件内容
        final PropertiesUtil properties = new PropertiesUtil("mail");
        //创建Properties类用于记录邮箱的一些属性
        final Properties props = new Properties();
        //表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth","true");
        //SMTP服务器
        props.put("mail.smtp.host",properties.getValue("mail.smtp.service"));
        //设置端口号 qq邮箱给出了两个 465/587
        props.put("mail.smtp.port",properties.getValue("mail.smtp.port"));
        //设置发送邮箱
        props.put("mail.user",properties.getValue("mail.from.address"));
        //设置发送邮箱的16位STMP口令
        props.put("mail.password",properties.getValue("mail.from.smtp.pwd"));

        //构建授权信息，用于进行STMP进行身份验证
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        //使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        //创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        //设置发件人
        String nickName = MimeUtility.encodeText(properties.getValue("mail.from.nickName"));
        InternetAddress form = new InternetAddress(nickName + "<" + props.getProperty("mail.user") + ">");
        message.setFrom(form);

        //设置邮件标题
        message.setSubject(mail.getTitle());
        //html发送邮件
        if(mail.getContentType().equals(MailContentTypeEnum.HTML.getValue())){
            //设置邮件的内容体
            message.setContent(mail.getContent(),mail.getContentType());
        }else if(mail.getContentType().equals(MailContentTypeEnum.TEXT.getValue())){
            message.setText(mail.getContent());
        }
        //发送邮箱地址
        List<String> targets = mail.getList();
        for(int i=0;i < targets.size();i++){
            try{
                //设置收件人的邮箱
                InternetAddress to = new InternetAddress(targets.get(i));
                message.setRecipient(Message.RecipientType.TO,to);
                //发送邮件
                Transport.send(message);
            }catch (Exception e){
                continue;
            }
        }
    }

}

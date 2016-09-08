import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shenlan.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangwei on 2016/9/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private VelocityEngine velocityEngine;

    @Test
    public void sendSimpleMail() throws Exception{
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("m15101172298@163.com");
        message.setTo("373257264@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
    }

    /**
     * 附件
     * @throws Exception
     */
    @Test
    public void sendAttachmentsMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("m15101172298@163.com");
        helper.setTo("373257264@qq.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");

        FileSystemResource file = new FileSystemResource(new File("weixin.png"));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.jpg", file);

        mailSender.send(mimeMessage);
    }

    /**
     * 静态资源
     * @throws Exception
     */
    @Test
    public void sendInlineMail() throws Exception{
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setFrom("m15101172298@163.com");
        helper.setTo("373257264@qq.com");
        helper.setSubject("主题：嵌入静态资源的测试");
        helper.setText("<html><body><img src=\"cid:weixin\"></body></html>",true);

        FileSystemResource file = new FileSystemResource(new File("weixin.png"));
        helper.addInline("weixin",file);
        mailSender.send(mimeMessage);
    }

    /**
     * 模板邮件
     * @throws Exception
     */
    @Test
    public void sendTemplateMail() throws Exception{
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setFrom("m15101172298@163.com");
        helper.setTo("373257264@qq.com");
        helper.setSubject("模板邮件");

        Map<String,Object> model = new HashMap<String,Object>();
        model.put("username","wangwei");
        String text  = VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine,"templates.vm","UTF-8",model);
        helper.setText(text,true);
        mailSender.send(mimeMessage);
    }
}

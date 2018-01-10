package mariuszjaczewski.repository_rest.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class EmailSenderImpl implements EmailSender{

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String to, String title, String content){
        MimeMessage mail = javaMailSender.createMimeMessage();

        try{
             MimeMessageHelper helper = new MimeMessageHelper(mail, true);
             helper.setTo(to);
             helper.setReplyTo("turkusowymail@gmail.com");
             helper.setFrom("turkusowymail@gmail.com");
            helper.setSubject(title);
            helper.setText(content);
            System.err.println("Wysłano emaila");
        }
        catch(MessagingException e){
            e.printStackTrace();
        }
        javaMailSender.send(mail);
    }

}

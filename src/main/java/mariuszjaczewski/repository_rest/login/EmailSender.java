package mariuszjaczewski.repository_rest.login;

public interface EmailSender {

        void sendEmail(String to, String subject, String content);


}

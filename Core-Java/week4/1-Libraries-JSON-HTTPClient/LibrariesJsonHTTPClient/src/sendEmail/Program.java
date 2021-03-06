package sendEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class Program {
    public static void main(String[] args) {

        try {
            EmailAttachment emailAttachment = new EmailAttachment();

            emailAttachment.setPath("azbW3zq_460sa_v1.gif");
            emailAttachment.setDescription("This is my picture");
            emailAttachment.setName("Zdravko");
            emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);

            MultiPartEmail email = new MultiPartEmail();

            email.setHostName("smtp.gmail.com");
            email.addTo("zddavko@gmail.com", "Zdravko");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("zddavko@gmail.com", ""));
            email.setSSLOnConnect(true);
            email.setDebug(true);
            email.setFrom("zddavko@gmail.com", "Me");
            email.setSubject("My picture");
            email.setMsg("Here is the picture you wanted");

            email.attach(emailAttachment);

            email.send();
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Sended.");
    }
}
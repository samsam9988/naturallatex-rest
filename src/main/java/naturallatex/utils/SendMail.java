
package naturallatex.utils;
 
import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;
 
public class SendMail {
 
    private static final Logger logger = Logger.getLogger(SendMail.class);
 
    private String from;
    private String to;
    private String subject;
    private String text;
 
    public SendMail(String from, String to, String subject, String text){
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.text = text;
    }
 
    public void sendReplyTo(String replyToEmailAddress) {
        Session mailSession = createSmtpSession();
        mailSession.setDebug (true);

        try {
            Transport transport = mailSession.getTransport ();

            MimeMessage message = new MimeMessage (mailSession);

            message.setSubject (this.subject);
            message.setFrom (new InternetAddress (this.from));
//            message.setReplyTo(InternetAddress.parse(this.from));
            message.setReplyTo(new javax.mail.Address[] {
                new InternetAddress(replyToEmailAddress)
            });
            message.setContent (text, "text/plain");
            message.addRecipient (Message.RecipientType.TO, new InternetAddress (this.to));

            transport.connect ();
            transport.sendMessage (message, message.getRecipients (Message.RecipientType.TO));  
        }
        catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
  * Send a single email.
  */
    public void send() {
        Session mailSession = createSmtpSession();
        mailSession.setDebug (true);

        try {
            Transport transport = mailSession.getTransport ();

            MimeMessage message = new MimeMessage (mailSession);

            message.setSubject (this.subject);
            message.setFrom (new InternetAddress (this.from));

            message.setContent (text, "text/plain");
            message.addRecipient (Message.RecipientType.TO, new InternetAddress (this.to));

            transport.connect ();
            transport.sendMessage (message, message.getRecipients (Message.RecipientType.TO));  
        }
        catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private Session createSmtpSession() {
        final Properties props = new Properties();
        props.setProperty ("mail.host", "smtp.googlemail.com");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty ("mail.transport.protocol", "smtp");
        props.setProperty("mail.debug", "true");

        return Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication("test.mymail.009@gmail.com", "mytestpass");
            }
        });
    }
  
}
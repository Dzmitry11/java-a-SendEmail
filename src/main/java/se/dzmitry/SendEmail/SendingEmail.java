package se.dzmitry.SendEmail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class SendingEmail implements EmailSender {

    private final String username;
    private final String password;
    private final Properties properties;

    public SendingEmail(String username, String password) {
        this.username = username;
        this.password = password;
        this.properties = new Properties();
        //dessa properties är för gmail
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");
    }

    @Override
    public void sendEmail(String to, String subject, String messageText) {
        doSendEmail(to, subject, messageText, null);
    }

    @Override
    public void sendEmail(String to, String subject, String messageText, String cc) {
        doSendEmail(to, subject, messageText, cc);
    }

    private void doSendEmail(String to, String subject, String messageText, String cc) {
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });


        try {
            Message message = new MimeMessage(session);
            //använd username-attributet här
            message.setFrom(new InternetAddress(this.username));
            //använd parametern to här
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //om parametern cc inte är null - skicka en kopia av mejlet till cc-adressen
            //använd paramtern subject här
            message.setSubject(subject);
            //använd parametern messageText här
            message.setText(messageText);

            if (cc != null) {
                message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
            }

            //skicka meddelandet
            Transport.send(message);
            System.out.println("Email sent");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        System.out.println("End");
    }

    public static void main(String[] args) {
        SendingEmail emailSender = new SendingEmail("dzmitry@gmail.com", "Dzmitry");
        emailSender.sendEmail("dzmitry@gmail.com", "Dzmitry", "It is a test");
    }


}

//      public void setUsername (String username){
    //        this.username = username;
      //  }

    //}

//public void setPassword(String password) {
//    this.password = password;
//}

//public void setProperties(Properties properties) {
//    this.properties = properties;
//}

//public String getUsername() {
//    return username;
//}

//public String getPassword() {
//    return password;
//}

//public Properties getProperties() {
//    return properties;
//}

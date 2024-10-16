package se.dzmitry.SendEmail;

import java.util.List;

public interface EmailSender {
    //Skicka mejl med mottagare, rubrik och innehåll
    public void sendEmail(String to, String subject, String messageText);


    //Skicka mejl med mottagare, rubrik, innehåll och cc:ad mail-adress
    public void sendEmail(String to, String subject, String messageText, String cc);
}


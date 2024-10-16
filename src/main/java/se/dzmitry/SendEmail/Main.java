package se.dzmitry.SendEmail;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SendingEmail sendingEmail = new SendingEmail("89850579967n@gmail.com", "cxuc hpjo xkbr laou");
        sendingEmail.sendEmail("olga.v.vlasova@yandex.ru", "Java test", "It is message from Java SE");
        //sendingEmail.SendEmail("89850579967n@gmail.com, "Hi", "I am doing well", "Hello Java"")

    //    JTextField mailAddressField = new JTextField(20);
    //    JTextField mailSubjectField = new JTextField(20);
    //    JTextField mailTextField = new JTextField(20);

        
    }
}

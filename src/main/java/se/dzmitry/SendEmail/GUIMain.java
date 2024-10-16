package se.dzmitry.SendEmail;

import javax.swing.*;

public class GUIMain {
    public static void main(String[] args) {


        JTextField mailAddressField = new JTextField(20);
        JTextField mailSubjectField = new JTextField(20);
        JTextField mailTextField = new JTextField(20);

        JPanel emailPanel = new JPanel();
        emailPanel.add(new JLabel("Till: "));
        emailPanel.add(mailAddressField);
        emailPanel.add(new JLabel("Subject: "));
        emailPanel.add(mailSubjectField);
        emailPanel.add(new JLabel("Text: "));
        emailPanel.add(mailTextField);
        emailPanel.add(Box.createHorizontalStrut(15));

        int result = JOptionPane.showConfirmDialog(null, emailPanel,
                "Ändra rubriken på din applikation här",
                JOptionPane.OK_CANCEL_OPTION);

        // Om användaren klickar på "OK", returnera ett nytt Email-objekt
        if (result == JOptionPane.OK_OPTION) {
            String to = mailAddressField.getText();
            String subject = mailSubjectField.getText();
            String messageText = mailTextField.getText();
            // Rensa textfälten efter användning
            mailAddressField.setText("");
            mailSubjectField.setText("");
            mailTextField.setText("");
            //här skickar du mejl eller skriver ut med System.out.println som tidigare

            System.out.println("Skickar mejl till: " + to + "\nÄmne: " +
                    subject + "\nText: " + messageText);
            // Rensa textfälten efter användning
            mailAddressField.setText("");
            mailSubjectField.setText("");
            mailTextField.setText("");
            SendingEmail emailSender = new SendingEmail("89850579967n@gmail.com",
                    "cxuc hpjo xkbr laou");
            emailSender.sendEmail(to, subject, messageText);
        }


    }
}

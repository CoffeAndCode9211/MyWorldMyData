package com.main.java;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {
    public static void main(String[] args) {

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", "mail.etipl.com");
        properties.setProperty("mail.user", "ashish@etipl.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.user", "ashish@etipl.com");
        properties.put("mail.smtp.password", "ashish123");
        properties.put("mail.smtp.port", "25");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ashish@etipl.com", "ashish123");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ashish@etipl.com"));
            message.addRecipients(Message.RecipientType.TO, "ashishkumar9211@gmail.com");
            message.setSubject("Hello World");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("this is message body");
            messageBodyPart.setContent("<html>This is testing</html>", "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            Transport.send(message);

        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }


}

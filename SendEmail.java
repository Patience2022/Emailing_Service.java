/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author patce
 */
public class SendEmail 
{
    public String getRandom()
    {
        Random random = new Random();
        int number = random.nextInt(999999);
        return String.format("%06d", number);
    }
    
    public boolean sendEmail(User user) throws Exception
    {
        boolean test = false;
        String toEmail = user.getEmail() ;
        String fromEmail = ""; //insert sender's email
        String fromPassword =""; //insert senders' password
        
        // creating properties (empty values to be set as per sender's email server info)
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", "");
        properties.setProperty("mail.smtp.port", "");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "");
        properties.put("mail.smtp.socketFactory.port", "");
        properties.put("mail.smtp.socket.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        
        //getting session
        Session session = Session.getInstance(properties, new Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(fromEmail,fromPassword);
                
            }
            
        });
        //send message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(fromEmail));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        msg.setSubject("User email verification");
        msg.setText("Please enter this code to verify your account: "+ user.getCode());
        Transport.send(msg);
        test = true;
        return test;
        
    }

}


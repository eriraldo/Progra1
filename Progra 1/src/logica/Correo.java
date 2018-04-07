
package logica;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
public class Correo {

    public static void main(String args[])
    {
        try
        {
            String host ="smtp.gmail.com" ;
            String user = "progradepoo1@gmail.com";
            String pass = "progradePOO";
            String to = "ericksalazar_g@hotmail.com ";
            String to1 = "dereckescalante@hotmail.com";
            //String to2 = "jopablox99@gmail.com";
            String from = "progradepoo1@gmail.com";
            String subject = "una mas";
            String messageText = "anemonas 69";
            boolean sessionDebug = false;

            Properties props = System.getProperties();//para definir direntes tipos de propiedades

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            //se necesita seguridad, pero java ya nos da seguridad
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));//correo de la persona que lo manda
            InternetAddress[] address = {new InternetAddress(to)};//correo de la persona que lo recibe
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());//fecha del evio del correo
            msg.setText(messageText);//mensaje actual

           Transport transport=mailSession.getTransport("smtp");//servidor por el que se va a mandar el correo
           transport.connect(host, user, pass);//se necesita autenticar el usuario y la contrasena
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
           
           //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            //se necesita seguridad, pero java ya nos da seguridad
            Session mailSession2 = Session.getDefaultInstance(props, null);
            mailSession2.setDebug(sessionDebug);
            Message msg2 = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));//correo de la persona que lo manda
            InternetAddress[] address2 = {new InternetAddress(to1)};//correo de la persona que lo recibe
            msg.setRecipients(Message.RecipientType.TO, address2);
            msg.setSubject(subject); msg.setSentDate(new Date());//fecha del evio del correo
            msg.setText(messageText);//mensaje actual

           Transport transport2=mailSession.getTransport("smtp");//servidor por el que se va a mandar el correo
           transport.connect(host, user, pass);//se necesita autenticar el usuario y la contrasena
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
           
        }
        catch(Exception ex)
        {
            System.out.println(ex);//si algo pasa con el envio del correo tira un mensaje
        }

    }
}





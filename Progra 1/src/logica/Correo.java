package logica;



import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author erick
 * @author dereck
 */
public class Correo {

    /**
     * envia el correo electronico
     */
    public Correo(){
        
    }

    /**
     *recibe el destinatario y el cuerpo del email para ser enviado
     * @param destinatario
     * @param descripcion
     */
    public void sendMail(String destinatario,String descripcion)
    {
        try
        {
            
                    
                   
            String host ="smtp.gmail.com" ;
            String user = "automaticcounterbot@gmail.com";
            String pass = "progradepoo";
            String to = destinatario;
            
            
            String from = "automaticcounterbot@gmail.com";
            String subject = "Alerta de envio";
            String messageText = "Estimado cliente,\nNos complace informarle que ya se pueden retirar los entregables con la siguiente descripcion:\n"+descripcion+"\n\nFavor dirijase a su counter mas cercano para proceder con el retiro\n\nGracias!\n";
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
           
           
           
        }
        catch(Exception ex)
        {
            System.out.println(ex);//si algo pasa con el envio del correo tira un mensaje
            
        }

    }
}




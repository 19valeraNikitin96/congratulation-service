package oleh.congratulationservice.service.mail.impl;

import oleh.congratulationservice.service.mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendSimpleMessage(String to, String message) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setFrom("senderservice@zohomail.eu");
        msg.setText(message);
        try{
            sender.send(msg);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

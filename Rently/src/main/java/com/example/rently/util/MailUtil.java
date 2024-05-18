package com.example.rently.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.example.rently.model.Property;

@Component
public class MailUtil {

    @Autowired
    private JavaMailSender mailSender;

    public void sendInterestEmail(Property property) {
        // Send email to buyer
        SimpleMailMessage buyerMessage = new SimpleMailMessage();
        buyerMessage.setTo("buyer@example.com");
        buyerMessage.setSubject("Interest in Property");
        buyerMessage.setText("You have expressed interest in the property: " + property.getPlace());
        mailSender.send(buyerMessage);

        // Send email to seller
        SimpleMailMessage sellerMessage = new SimpleMailMessage();
        sellerMessage.setTo("seller@example.com");
        sellerMessage.setSubject("Interest in Your Property");
        sellerMessage.setText("A buyer has expressed interest in your property: " + property.getPlace());
        mailSender.send(sellerMessage);
    }
}

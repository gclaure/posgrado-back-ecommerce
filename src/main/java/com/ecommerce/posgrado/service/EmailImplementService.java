package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.request.EmailNotificationRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author gclaure from CochaSoft
 * Date: 6/1/23
 * Time: 21:30
 * Project Name: posgrado
 */
@Service
public class EmailImplementService implements EmailInterfaceService {

    private final JavaMailSender javaMailSender;

    public EmailImplementService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public String send(EmailNotificationRequest request) {
        if (request.isHasTemplate()) {
            sendTemplate(request);
        } else {
            sendPlainText(request);
        }
        return "Your email has been sent successfully";
    }

    private void sendPlainText(EmailNotificationRequest email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email.getTo());
        mailMessage.setSubject(email.getSubject());
        mailMessage.setText(email.getBody());
        this.javaMailSender.send(mailMessage);
    }

    private void sendTemplate(EmailNotificationRequest email) {
        MimeMessage mailMessage = this.javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage);
        try {
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getBody(), true);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        this.javaMailSender.send(mailMessage);
    }
}

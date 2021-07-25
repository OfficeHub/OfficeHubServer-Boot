package com.officehub.officehubserver.OfficeHubServer.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    private JavaMailSender javaMailSender;
    private static final String FROM_ADDRESS = "officehub@officehub.com";

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendWelcomeMail(String toAddress) throws Exception{
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toAddress);
        message.setSubject("OfficeHub 가입 환영 메일");
        message.setText("가입해주셔서 감사합니다^^");
        javaMailSender.send(message);
    }
}

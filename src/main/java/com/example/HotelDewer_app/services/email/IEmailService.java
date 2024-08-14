package com.example.HotelDewer_app.services.email;

import jakarta.mail.MessagingException;

import java.io.File;

public interface IEmailService {
    void sendEmail(String [] toUser, String subject, String message);

    void sendEmailWithFile(String[] toUser, String subject, String message, File file) throws MessagingException;
}

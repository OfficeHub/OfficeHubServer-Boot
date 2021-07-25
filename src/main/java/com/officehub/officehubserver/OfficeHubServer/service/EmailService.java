package com.officehub.officehubserver.OfficeHubServer.service;

public interface EmailService {
    void sendWelcomeMail(String toAddress) throws Exception;
}

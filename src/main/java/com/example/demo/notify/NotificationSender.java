package com.example.demo.notify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificationSender {

    private final Map<String, NotificationService> services;

    // Автоматическое внедрение через конструктор
    @Autowired
    public NotificationSender(Map<String, NotificationService> service) {
        this.services = service;
    }

    public void notifyUser(String message, String nameService) {
        services.get(nameService).send(message);
    }

    // Внедрение через сеттер
  /*  @Autowired
    public void setSmsService(SmsService smsService) {
        this.service = smsService;
    }*/
}
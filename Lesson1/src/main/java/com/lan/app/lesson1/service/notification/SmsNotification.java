package com.lan.app.lesson1.service.notification;

import com.lan.app.lesson1.model.INotification;
import org.springframework.stereotype.Component;

@Component
public class SmsNotification implements INotification {
    @Override
    public void sendNotification(String to, String message) {
        System.out.println("Gửi thông báo qua sms tới " + to + ": " + message);
    }
}

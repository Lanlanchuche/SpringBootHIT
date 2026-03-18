package com.lan.app.lesson1.service.notification;

import com.lan.app.lesson1.model.INotification;
import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements INotification {
    @Override
    public void sendNotification(String to, String message) {
        System.out.println("Gửi thoong báo qua email đến " + to + ": " + message);
    }
}

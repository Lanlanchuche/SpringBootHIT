package com.lan.app.lesson1;

import com.lan.app.lesson1.service.OrderService;
import com.lan.app.lesson1.service.notification.SmsNotification;
import com.lan.app.lesson1.service.payment.BankTransferPayment;
import com.lan.app.lesson1.service.payment.CashPayment;
import com.lan.app.lesson1.service.payment.MoMoPayment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lesson1Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Lesson1Application.class, args);
        OrderService order1 = context.getBean(OrderService.class);

        //lấy các mảnh ghép (Bean) lẻ từ context ra và tự lắp vào
        OrderService order2 = new OrderService(context.getBean(MoMoPayment.class), context.getBean(SmsNotification.class));

        OrderService order3 = context.getBean(OrderService.class);
        order3.setPaymentMethod(context.getBean(BankTransferPayment.class));
        order3.setNotificationService(context.getBean(SmsNotification.class));

        order1.processOrder("Lan1", "táo", 20000);
        order2.processOrder("Lan2", "cam", 30000);
        order3.processOrder("Lan3", "lê", 50000);

    }

}

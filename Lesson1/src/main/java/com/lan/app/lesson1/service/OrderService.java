package com.lan.app.lesson1.service;

import com.lan.app.lesson1.model.INotification;
import com.lan.app.lesson1.model.IPaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private IPaymentMethod paymentMethod;
    private INotification notificationService;


    //@Autowired de DI tu dong
    @Autowired
    //Constructor Ịnection
    // @Qualifier de chi dinh chinh xac 1 bean
    //quy tac ten bean la ten class viet thuong chu cai dau
    public OrderService(@Qualifier("cashPayment") IPaymentMethod paymentMethod,  @Qualifier("emailNotification") INotification notificationService) {
        this.paymentMethod = paymentMethod;
        this.notificationService = notificationService;
    }
//Setter Injection
    public void setPaymentMethod(IPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setNotificationService(INotification notificationService) {
        this.notificationService = notificationService;
    }

    public void processOrder(String customer, String product, double amount) {
        System.out.println("Khách hàng : " + customer );
        System.out.println("Sản phẩm : " + product );
        String message = "Thanh toán " + amount + " thành công qua " + paymentMethod.getMethodName();
        notificationService.sendNotification(customer, message );

    }
}

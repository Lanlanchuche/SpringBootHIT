package com.lan.app.lesson1.service.payment;

import com.lan.app.lesson1.model.IPaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class MoMoPayment implements IPaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Đã thanh toán bằng ví Momo là " + amount);
    }

    @Override
    public String getMethodName() {
        return "Momo";
    }
}

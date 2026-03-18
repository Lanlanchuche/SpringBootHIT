package com.lan.app.lesson1.service.payment;

import com.lan.app.lesson1.model.IPaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class CashPayment implements IPaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Đã trả bằng tiền mặt với soos tiền là " + amount);
    }

    @Override
    public String getMethodName() {
        return "Tiền mặt";
    }
}

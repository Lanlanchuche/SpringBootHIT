package com.lan.app.lesson1.service.payment;

import com.lan.app.lesson1.model.IPaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class BankTransferPayment implements IPaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Đã thanh toans bằng tài khoản ngân hàng là " + amount);
    }

    @Override
    public String getMethodName() {
        return "Tài khoản ngân hàng";
    }
}

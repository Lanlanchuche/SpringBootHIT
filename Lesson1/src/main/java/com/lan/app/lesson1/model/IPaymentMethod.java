package com.lan.app.lesson1.model;

public interface IPaymentMethod {
    public void pay(double amount);
    public String getMethodName();
}

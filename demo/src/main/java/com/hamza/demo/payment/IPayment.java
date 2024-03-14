package com.hamza.demo.payment;

import java.util.List;

public interface IPayment {

    Payment addPayment(Payment payment);
    Payment getPaymentById(String id);
    List<Payment> getAllPayment();
}

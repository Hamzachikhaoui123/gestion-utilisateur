package com.hamza.demo.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {
    @Autowired
   private PaymentService paymentService;


    @PostMapping(path = "")
    public Payment addPayment(@RequestBody Payment payment){
        return paymentService.addPayment(payment);
    }

}

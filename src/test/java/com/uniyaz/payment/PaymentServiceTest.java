package com.uniyaz.payment;

import com.uniyaz.payment.domain.Payment;
import com.uniyaz.payment.service.PaymentService;
import com.uniyaz.rental.domain.Rental;
import com.uniyaz.rental.service.RentalService;
import org.junit.Test;

import java.util.List;

public class PaymentServiceTest {
    @Test
    public void findAllTest() {

       PaymentService paymentService = new PaymentService();
        List<Payment> paymentList = paymentService.findAll();
        for (Payment payment : paymentList) {
            System.out.println(payment);
        }

    }
}

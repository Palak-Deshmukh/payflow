package com.payflow.service;

import com.payflow.dao.PaymentDao;
import com.payflow.entity.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentDao paymentDao;

    public PaymentService(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }


    public Payment createPayment(Payment payment) {
        return paymentDao.save(payment);
    }


    public Payment getPaymentById(Long id) {

        return paymentDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }


    public List<Payment> getAllPayments() {
        return paymentDao.findAll();
    }


    public Payment updatePayment(Payment payment) {
        return paymentDao.save(payment);
    }


    public void deletePayment(Long id) {

        Payment payment = getPaymentById(id);
        paymentDao.delete(payment);
    }
}
package com.payflow.dao;

import com.payflow.entity.Payment;
import com.payflow.repository.PaymentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PaymentDao {

    private final PaymentRepository paymentRepository;

    public PaymentDao(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Optional<Payment> findById(Long id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public void delete(Payment payment) {
        paymentRepository.delete(payment);
    }

    public boolean existsById(Long id) {
        return paymentRepository.existsById(id);
    }
}
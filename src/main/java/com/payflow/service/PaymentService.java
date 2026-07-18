package com.payflow.service;

import com.payflow.dao.PaymentDao;
import com.payflow.dto.request.PaymentRequest;
import com.payflow.dto.response.PaymentResponse;
import com.payflow.entity.Payment;
import com.payflow.mapper.PaymentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private final PaymentDao paymentDao;

    public PaymentService(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    public PaymentResponse createPayment(PaymentRequest request) {

        Payment payment = PaymentMapper.toEntity(request);
        Payment savedPayment = paymentDao.save(payment);

        return PaymentMapper.toResponse(savedPayment);
    }

    public PaymentResponse getPaymentById(Long id) {

        Payment payment = paymentDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        return PaymentMapper.toResponse(payment);
    }

    public List<PaymentResponse> getAllPayments() {

        return paymentDao.findAll()
                .stream()
                .map(PaymentMapper::toResponse)
                .collect(Collectors.toList());
    }

    public PaymentResponse updatePayment(Long id, PaymentRequest request) {

        Payment existingPayment = paymentDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        // TODO: Fetch Users entity using userId later
        // existingPayment.setUser(userDao.findById(request.getUserId()).orElseThrow(...));

        existingPayment.setAmount(request.getAmount());
        existingPayment.setCurrency(request.getCurrency());
        existingPayment.setPaymentMethod(request.getPaymentMethod());

        Payment updatedPayment = paymentDao.save(existingPayment);

        return PaymentMapper.toResponse(updatedPayment);
    }

    public void deletePayment(Long id) {

        Payment payment = paymentDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        paymentDao.delete(payment);
    }
}
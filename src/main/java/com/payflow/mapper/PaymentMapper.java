package com.payflow.mapper;

import com.payflow.dto.request.PaymentRequest;
import com.payflow.dto.response.PaymentResponse;
import com.payflow.entity.Payment;

public class PaymentMapper {

    private PaymentMapper() {
    }

    public static Payment toEntity(PaymentRequest request) {
        if (request == null) {
            return null;
        }

        Payment payment = new Payment();

        payment.setAmount(request.getAmount());
        payment.setCurrency(request.getCurrency());
        payment.setPaymentMethod(request.getPaymentMethod());

        return payment;
    }

    public static PaymentResponse toResponse(Payment payment) {
        if (payment == null) {
            return null;
        }

        return PaymentResponse.builder()
                .id(payment.getId())
                .userId(payment.getUser().getId())
                .amount(payment.getAmount())
                .currency(payment.getCurrency())
                .status(payment.getStatus())
                .paymentMethod(payment.getPaymentMethod())
                .transactionId(payment.getTransactionId())
                .createdAt(payment.getCreatedAt())
                .build();
    }
}
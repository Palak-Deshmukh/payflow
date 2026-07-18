package com.payflow.mapper;

import com.payflow.dto.request.TransactionRequest;
import com.payflow.dto.response.TransactionResponse;
import com.payflow.entity.Transaction;

public class TransactionMapper {

    private TransactionMapper() {
    }

    public static Transaction toEntity(TransactionRequest request) {

        if (request == null) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setStatus(request.getStatus());
        transaction.setGatewayReference(request.getGatewayTransactionId());

        // Payment will be set in the service after fetching it from DB.

        return transaction;
    }

    public static TransactionResponse toResponse(Transaction transaction) {

        if (transaction == null) {
            return null;
        }

        return TransactionResponse.builder()
                .id(transaction.getId())
                .paymentId(
                        transaction.getPayment() != null
                                ? transaction.getPayment().getId()
                                : null
                )
                .status(transaction.getStatus())
                .gatewayTransactionId(transaction.getGatewayReference())
                .createdAt(transaction.getCreatedAt())
                .build();
    }
}
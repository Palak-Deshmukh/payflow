package com.payflow.service;

import com.payflow.dao.TransactionDao;
import com.payflow.dto.request.TransactionRequest;
import com.payflow.dto.response.TransactionResponse;
import com.payflow.entity.Transaction;
import com.payflow.mapper.TransactionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionDao transactionDao;

    public TransactionService(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public TransactionResponse createTransaction(TransactionRequest request) {

        Transaction transaction = TransactionMapper.toEntity(request);
        Transaction savedTransaction = transactionDao.save(transaction);

        return TransactionMapper.toResponse(savedTransaction);
    }

    public TransactionResponse getTransactionById(Long id) {

        Transaction transaction = transactionDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        return TransactionMapper.toResponse(transaction);
    }

    public List<TransactionResponse> getAllTransactions() {

        return transactionDao.findAll()
                .stream()
                .map(TransactionMapper::toResponse)
                .collect(Collectors.toList());
    }

    public TransactionResponse updateTransaction(Long id, TransactionRequest request) {

        Transaction existingTransaction = transactionDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        existingTransaction.setStatus(request.getStatus());
        existingTransaction.setGatewayReference(request.getGatewayTransactionId());

        // We'll set Payment later once PaymentDao is injected.
        // existingTransaction.setPayment(paymentDao.findById(request.getPaymentId()).orElseThrow(...));

        Transaction updatedTransaction = transactionDao.save(existingTransaction);

        return TransactionMapper.toResponse(updatedTransaction);
    }

    public void deleteTransaction(Long id) {

        Transaction transaction = transactionDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        transactionDao.delete(transaction);
    }
}
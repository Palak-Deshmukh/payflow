package com.payflow.service;

import com.payflow.dao.TransactionDao;
import com.payflow.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionDao transactionDao;

    public TransactionService(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }


    public Transaction createTransaction(Transaction transaction) {
        return transactionDao.save(transaction);
    }


    public Transaction getTransactionById(Long id) {

        return transactionDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }


    public List<Transaction> getAllTransactions() {
        return transactionDao.findAll();
    }


    public Transaction updateTransaction(Transaction transaction) {
        return transactionDao.save(transaction);
    }


    public void deleteTransaction(Long id) {

        Transaction transaction = getTransactionById(id);
        transactionDao.delete(transaction);
    }
}
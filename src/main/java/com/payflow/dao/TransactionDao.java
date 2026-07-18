package com.payflow.dao;

import com.payflow.entity.Transaction;
import com.payflow.repository.TransactionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TransactionDao {

    private final TransactionRepository transactionRepository;

    public TransactionDao(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public void delete(Transaction transaction) {
        transactionRepository.delete(transaction);
    }

    public boolean existsById(Long id) {
        return transactionRepository.existsById(id);
    }
}
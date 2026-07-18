package com.payflow.repository;

import com.payflow.entity.Transaction;
import com.payflow.entity.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findByGatewayReference(String gatewayReference);

    List<Transaction> findByPaymentId(Long paymentId);

    List<Transaction> findByStatus(PaymentStatus status);
}
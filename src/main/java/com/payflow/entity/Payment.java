package com.payflow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.payflow.entity.Users;


@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;


    @Column(nullable = false)
    private BigDecimal amount;


    @Column(nullable = false)
    private String currency;


    @Enumerated(EnumType.STRING)
    private PaymentStatus status;


    private String paymentMethod;


    @Column(unique = true)
    private String transactionId;


    private LocalDateTime createdAt;


    @OneToMany(mappedBy = "payment")
    private List<Transaction> transactions;


    @PrePersist
    public void prePersist() {

        createdAt = LocalDateTime.now();

        if(status == null) {
            status = PaymentStatus.CREATED;
        }
    }
}
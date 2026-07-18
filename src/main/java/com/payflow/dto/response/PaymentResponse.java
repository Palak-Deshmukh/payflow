package com.payflow.dto.response;

import com.payflow.entity.PaymentStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponse {

    private Long id;

    private Long userId;

    private BigDecimal amount;

    private String currency;

    private PaymentStatus status;

    private String paymentMethod;

    private String transactionId;

    private LocalDateTime createdAt;
}
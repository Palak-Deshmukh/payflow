package com.payflow.dto.response;

import com.payflow.entity.PaymentStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponse {

    private Long id;

    private Long paymentId;

    private PaymentStatus status;

    private String gatewayTransactionId;

    private LocalDateTime createdAt;
}
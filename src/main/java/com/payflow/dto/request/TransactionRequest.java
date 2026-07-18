package com.payflow.dto.request;

import com.payflow.entity.PaymentStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionRequest {

    private Long paymentId;

    private PaymentStatus status;

    private String gatewayTransactionId;
}
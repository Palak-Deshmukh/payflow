package com.payflow.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest {

    private Long userId;

    private BigDecimal amount;

    private String currency;

    private String paymentMethod;
}
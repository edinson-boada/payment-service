package com.unmsm.sistemas.microservice.paymentservice.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDto {
    private String id;
    private Double amount;
}

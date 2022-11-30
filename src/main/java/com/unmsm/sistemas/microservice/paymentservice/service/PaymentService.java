package com.unmsm.sistemas.microservice.paymentservice.service;

import com.unmsm.sistemas.microservice.paymentservice.model.InvoiceEntity;
import com.unmsm.sistemas.microservice.paymentservice.model.dto.PaymentDto;

public interface PaymentService {
    InvoiceEntity payService(PaymentDto request);
}
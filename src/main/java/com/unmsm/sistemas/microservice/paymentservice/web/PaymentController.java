package com.unmsm.sistemas.microservice.paymentservice.web;

import com.unmsm.sistemas.microservice.paymentservice.model.InvoiceEntity;
import com.unmsm.sistemas.microservice.paymentservice.model.dto.PaymentDto;
import com.unmsm.sistemas.microservice.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public InvoiceEntity payService(@RequestBody PaymentDto request) {
        return paymentService.payService(request);
    }
}
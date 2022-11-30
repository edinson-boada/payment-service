package com.unmsm.sistemas.microservice.paymentservice.service.impl;

import com.unmsm.sistemas.microservice.consultdebt.model.DebtEntity;
import com.unmsm.sistemas.microservice.paymentservice.client.DebtClient;
import com.unmsm.sistemas.microservice.paymentservice.model.InvoiceEntity;
import com.unmsm.sistemas.microservice.paymentservice.model.dto.PaymentDto;
import com.unmsm.sistemas.microservice.paymentservice.repository.InvoiceRepository;
import com.unmsm.sistemas.microservice.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final DebtClient debtClient;
    private final InvoiceRepository invoiceRepository;

    @Override
    public InvoiceEntity payService(PaymentDto request) {
        DebtEntity debt = debtClient.getDebtById(request.getId());
        InvoiceEntity invoice = new InvoiceEntity();
        invoice.setDebtId(debt.getId());
        invoice.setTotalInvoice(debt.getMonthlyPayment() + debt.getLatePayment());
        invoice.setTotalIgv((debt.getMonthlyPayment() + debt.getLatePayment()) * 0.18);
        invoice.setCreateAt(LocalDate.now());
        debt.setPayed(true);
        debtClient.updateDebt(debt);
        return invoiceRepository.save(invoice);
    }
}
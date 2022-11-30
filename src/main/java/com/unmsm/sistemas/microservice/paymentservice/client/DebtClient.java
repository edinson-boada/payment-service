package com.unmsm.sistemas.microservice.paymentservice.client;

import com.unmsm.sistemas.microservice.consultdebt.model.DebtEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "consult-debt")
public interface DebtClient {

    @GetMapping("/api/debts/{id}")
    DebtEntity getDebtById(@PathVariable("id") String id);

    @PostMapping("/api/debts")
    DebtEntity updateDebt(@RequestBody DebtEntity debtEntity);
}

package com.unmsm.sistemas.microservice.paymentservice.repository;

import com.unmsm.sistemas.microservice.paymentservice.model.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Integer>{
}
package com.Myproject.insurance.repository;

import com.Myproject.insurance.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByPaymentUid(String PaymentUid);
}

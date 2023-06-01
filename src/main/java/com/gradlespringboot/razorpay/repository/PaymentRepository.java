package com.gradlespringboot.razorpay.repository;

import com.gradlespringboot.razorpay.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}

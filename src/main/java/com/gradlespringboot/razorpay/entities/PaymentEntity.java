package com.gradlespringboot.razorpay.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "razorpay")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "Payment_id")
    private String paymentId;
    @Column(name = "amount")
    private float amount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "method")
    private String method;

    @Column(name = "receipt")
    private String receipt;
@Column(name = "appointmentId")
private String appointmentId;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private String created_at;

    public PaymentEntity() {
    }

    public PaymentEntity(String orderId,String payment_id, float amount, String currency, String method, String appointmentId, String status, String created_at, String paymentId, String receipt) {
        this.orderId = orderId;
        this.paymentId = paymentId;
        this.amount = amount;
        this.currency = currency;
        this.method = method;
        this.appointmentId = appointmentId;
        this.status = status;
        this.created_at = created_at;
        this.receipt=receipt;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPaymentId() {
        return orderId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

public String getCreated_at() {
    return created_at;
}

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}

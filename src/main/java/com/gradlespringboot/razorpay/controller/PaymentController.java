package com.gradlespringboot.razorpay.controller;

import com.gradlespringboot.razorpay.entities.PaymentEntity;
import com.gradlespringboot.razorpay.repository.PaymentRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/payment")
    public String showPaymentPage() {
        return "payment";
    }

    @RequestMapping("/payment")
    @ResponseBody
    public String processPayment(@RequestParam Map<String, Object> data) throws Exception {
        System.out.println(data);
        Object amountObj = data.get("amount");
        if (amountObj == null) {
            return "Error: amount parameter is required";
        }
        float amt = Float.parseFloat(amountObj.toString());
        Order order = null;
        try {
            RazorpayClient rj = new RazorpayClient("rzp_test_QvfhRP9slPcend", "mhCcqqxaDZ3wP3CKzBCC5XuB");

            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", (int)(amt * 100)); // amount in the smallest currency unit
            orderRequest.put("currency","INR");
            //orderRequest.put("receipt", "order_rcptid_11");
            orderRequest.put("receipt", "order_appointmentId_11");
            //creating new PaymentEntity
            order = rj.orders.create(orderRequest);
            System.out.println(order);

            //save payments in database
            PaymentEntity paymentEntity = new PaymentEntity();

            paymentEntity.setOrderId(order.get("id") != null ? order.get("id").toString() : null);
            paymentEntity.setPaymentId(order.get("paymentId")!= null ? order.get("paymentId").toString() : null);
            paymentEntity.setAmount(order.get("amount") != null ? Float.parseFloat(order.get("amount").toString())/100 : null);
            paymentEntity.setCurrency(order.get("currency") != null ? order.get("currency").toString() : null);
            paymentEntity.setMethod(order.get("method") != null ? order.get("method").toString() : null);
            //paymentEntity.setReceipt(order.get("receipt") != null ? order.get("receipt").toString() : null);
            paymentEntity.setAppointmentId(order.get("appointmentId") != null ? order.get("appointmentId").toString() : null);
            paymentEntity.setStatus(order.get("status") != null ? order.get("status").toString() : null);
            paymentEntity.setCreated_at(order.get("created_at")!= null ? order.get("created_at").toString() : null);

            this.paymentRepository.save(paymentEntity);

        } catch (Exception e) {
            System.out.println("Order generation error: " + e.getMessage());
            throw e;
        }
        return order.toString();
    }
}
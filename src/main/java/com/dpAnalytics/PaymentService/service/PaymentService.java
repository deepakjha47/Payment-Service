package com.dpAnalytics.PaymentService.service;

import com.dpAnalytics.PaymentService.model.PaymentRequest;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);
}

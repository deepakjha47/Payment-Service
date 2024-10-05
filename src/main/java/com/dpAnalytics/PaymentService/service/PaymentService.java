package com.dpAnalytics.PaymentService.service;

import com.dpAnalytics.PaymentService.model.PaymentRequest;
import com.dpAnalytics.PaymentService.model.PaymentResponse;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(long orderId);
}

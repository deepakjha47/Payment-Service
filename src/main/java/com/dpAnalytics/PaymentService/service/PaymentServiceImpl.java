package com.dpAnalytics.PaymentService.service;

import com.dpAnalytics.PaymentService.entity.TransactionDetails;
import com.dpAnalytics.PaymentService.model.PaymentMode;
import com.dpAnalytics.PaymentService.model.PaymentRequest;
import com.dpAnalytics.PaymentService.repository.TransactionDetailsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;
    @Override
    public Long doPayment(PaymentRequest paymentRequest) {
        log.info("Recording payment request: {}", paymentRequest);

        TransactionDetails transactionDetails =
                TransactionDetails.builder()
                .paymentMode(paymentRequest.getPaymentMode().name())
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .paymentDate(Instant.now())
                .paymentStatus("SUCCESS")
                .amount(paymentRequest.getAmount())
                .build();

        transactionDetailsRepository.save(transactionDetails);

        log.info("Transaction completed with reference number: {}", transactionDetails.getId());

        return transactionDetails.getId();
    }
}

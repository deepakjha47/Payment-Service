package com.dpAnalytics.PaymentService.repository;

import com.dpAnalytics.PaymentService.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long> {

    /**
     * Since in spring we have find by id but we need to find by orderId
     * which is not a primary key in payment db so we have to extend that method
     * findBY+fieldname+ fieldname should follow camelcase
     * rest thing will be done by spring
     */
    TransactionDetails findByOrderId(long orderId);
}

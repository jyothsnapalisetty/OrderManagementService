package com.ordermanagement.repository;

import com.ordermanagement.dto.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderManagementRepository extends JpaRepository<Order, Long> {
    
}

package com.ordermanagement.service;

import com.ordermanagement.dto.Order;
import com.ordermanagement.model.OrderRequest;
import com.ordermanagement.model.OrderResponse;
import com.ordermanagement.repository.OrderManagementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderManagementService {
    private final OrderManagementRepository orderManagementRepository;

    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .productId(orderRequest.getProductId())
                .productName(orderRequest.getProductName())
                .productQuantity(orderRequest.getProductQuantity())
                .productStatus(orderRequest.getProductStatus().toString()).build();

        Order savedOrder = orderManagementRepository.save(order);
        return new OrderResponse(savedOrder.getId(), savedOrder.getOrderStatus().name());
    }

    public OrderResponse fetchOrder(Long orderId) {
        Order order = orderManagementRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order Not Found"));
        return new OrderResponse(order.getId(), order.getOrderStatus().name());
    }

}

package com.ordermanagement.controller;

import com.ordermanagement.model.OrderRequest;
import com.ordermanagement.model.OrderResponse;
import com.ordermanagement.service.OrderManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderManagementController {
    private final OrderManagementService orderManagementService;

    @PostMapping
    public OrderResponse createOrder(OrderRequest orderRequest){
        OrderResponse newOrder=orderManagementService.createOrder(orderRequest);
        return ResponseEntity.ok(newOrder).getBody();
    }

    @GetMapping("/id/{orderId}")
    public OrderResponse fetchOrder(Long orderId){
       OrderResponse fetchedOrder=orderManagementService.fetchOrder(orderId);
        return ResponseEntity.accepted().body(fetchedOrder).getBody();

    }
}
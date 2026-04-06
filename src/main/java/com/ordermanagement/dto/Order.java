package com.ordermanagement.dto;

import com.ordermanagement.model.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="order")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Order {
    @Id
    private Long id;
    @Column(nullable = false, unique = true)
    private String productId;
    @Column(nullable = false)
    private String productName;
    private int productQuantity;
    private String productStatus;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}

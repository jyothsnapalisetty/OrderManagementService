package com.ordermanagement.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NonNull;

@Data
public class OrderRequest {
    @NonNull
    private String productId;
    @NonNull
    private String productName;
    private int productQuantity;
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;
}

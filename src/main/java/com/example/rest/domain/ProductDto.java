package com.example.rest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ProductDto {
    private UUID id;
    private String title;
    private String description;
    private BigDecimal price;
    private LocalDateTime createdAt;
}

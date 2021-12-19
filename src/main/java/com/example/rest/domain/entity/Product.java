package com.example.rest.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;
    private String description;
    private BigDecimal price;
    private Boolean isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @Builder.Default
    private Customer customer = new Customer();
}

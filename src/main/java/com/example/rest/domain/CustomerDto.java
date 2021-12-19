package com.example.rest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class CustomerDto {
    private UUID id;
    private String title;
    private LocalDateTime createdAt;
}

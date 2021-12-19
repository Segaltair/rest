package com.example.rest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class CustomerDto {
    private UUID id;
    private String title;
    private LocalDateTime createdAt;
}

package com.example.rest.service;

import com.example.rest.domain.CustomerDto;
import com.example.rest.domain.ProductDto;
import com.example.rest.domain.request.ProductRequest;
import com.example.rest.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public List<ProductDto> getProducts(UUID customerId) {
        return null;
    }

    public ProductDto createProduct(UUID customerId, ProductRequest request) {
        return null;
    }

    public void deleteProduct(UUID productId) {

    }

    public CustomerDto getProduct(UUID productId) {
        return null;
    }

    public CustomerDto updateProduct(UUID productId, ProductRequest request) {
        return null;
    }
}

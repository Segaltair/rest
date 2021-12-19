package com.example.rest.controller;

import com.example.rest.domain.CustomerDto;
import com.example.rest.domain.ProductDto;
import com.example.rest.domain.request.ProductRequest;
import com.example.rest.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("customers/{customerId}/products")
    public List<ProductDto> getProducts(
            @PathVariable UUID customerId
    ) {
        return productService.getProducts(customerId);
    }

    @PostMapping("customers/{customerId}/products")
    public ProductDto createProduct(
            @PathVariable UUID customerId,
            @RequestBody ProductRequest request
    ) {
        return productService.createProduct(customerId, request);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(
            @PathVariable UUID productId
    ) {
        productService.deleteProduct(productId);
    }

    @GetMapping("/products/{productId}")
    public CustomerDto getProduct(
            @PathVariable UUID productId
    ) {
        return productService.getProduct(productId);
    }

    @PutMapping("/products/{productId}")
    public CustomerDto updateCustomer(
            @PathVariable UUID productId,
            @RequestBody ProductRequest request
    ) {
        return productService.updateProduct(productId, request);
    }
}

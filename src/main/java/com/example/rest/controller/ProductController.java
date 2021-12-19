package com.example.rest.controller;

import com.example.rest.domain.ProductDto;
import com.example.rest.domain.request.ProductRequest;
import com.example.rest.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("customers/{customerId}/products")
    public Page<ProductDto> getProducts(
            @PathVariable UUID customerId,
            Pageable pageable
    ) {
        return productService.getProducts(customerId, pageable);
    }

    @PostMapping("customers/{customerId}/products")
    public ProductDto createProduct(
            @PathVariable UUID customerId,
            @NotNull @Valid @RequestBody ProductRequest request
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
    public ProductDto getProduct(
            @PathVariable UUID productId
    ) {
        return productService.getProduct(productId);
    }

    @PutMapping("/products/{productId}")
    public ProductDto updateProduct(
            @PathVariable UUID productId,
            @NotNull @Valid @RequestBody ProductRequest request
    ) {
        return productService.updateProduct(productId, request);
    }
}

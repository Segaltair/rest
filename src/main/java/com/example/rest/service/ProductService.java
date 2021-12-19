package com.example.rest.service;

import com.example.rest.domain.ProductDto;
import com.example.rest.domain.entity.Product;
import com.example.rest.domain.request.ProductRequest;
import com.example.rest.repository.CustomerRepository;
import com.example.rest.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    private CustomerRepository customerRepository;

    public Page<ProductDto> getProducts(UUID customerId, Pageable pageable) {
        return productRepository.findAllByCustomer_Id(customerId, pageable)
                .map(this::toDto);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ProductDto createProduct(UUID customerId, ProductRequest request) {
        final var customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        
        final var product = Product.builder()
                .id(UUID.randomUUID())
                .title(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .isDeleted(false)
                .createdAt(LocalDateTime.now())
                .modifiedAt(null)
                .customer(customer)
                .build();

        return toDto(productRepository.save(product));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteProduct(UUID productId) {
        final var product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setIsDeleted(true);
        product.setModifiedAt(LocalDateTime.now());

        productRepository.save(product);
    }

    public ProductDto getProduct(UUID productId) {
        final var product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return toDto(product);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ProductDto updateProduct(UUID productId, ProductRequest request) {
        final var product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        var modified = false;
        if (request.getTitle() != null) {
            modified = true;
            product.setTitle(request.getTitle());
        }
        if (request.getDescription() != null) {
            modified = true;
            product.setDescription(request.getDescription());
        }
        if (request.getPrice() != null) {
            modified = true;
            product.setPrice(request.getPrice());
        }

        if (modified) {
            product.setModifiedAt(LocalDateTime.now());
            return toDto(productRepository.save(product));
        } else {
            return toDto(product);
        }
    }

    private ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .createdAt(product.getCreatedAt())
                .build();
    }
}

package com.example.rest.service;

import com.example.rest.domain.CustomerDto;
import com.example.rest.domain.entity.Customer;
import com.example.rest.domain.request.CustomerRequest;
import com.example.rest.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public Page<CustomerDto> getCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable)
                .map(this::toDto);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public CustomerDto createCustomer(CustomerRequest request) {
        final var customer = Customer.builder()
                .id(UUID.randomUUID())
                .title(request.getTitle())
                .isDeleted(false)
                .createdAt(LocalDateTime.now())
                .modifiedAt(null)
                .products(new ArrayList<>())
                .build();

        return toDto(customerRepository.save(customer));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteCustomer(UUID customerId) {
        final var customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setIsDeleted(true);

        customerRepository.save(customer);
    }

    public CustomerDto getCustomer(UUID customerId) {
        final var customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return toDto(customer);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public CustomerDto updateCustomer(UUID customerId, CustomerRequest request) {
        final var customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (request.getTitle() != null) {
            customer.setTitle(request.getTitle());
            customer.setModifiedAt(LocalDateTime.now());
            return toDto(customerRepository.save(customer));
        } else {
            return toDto(customer);
        }
    }

    private CustomerDto toDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .title(customer.getTitle())
                .createdAt(customer.getCreatedAt())
                .build();
    }
}

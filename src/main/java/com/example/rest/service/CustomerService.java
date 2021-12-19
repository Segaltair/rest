package com.example.rest.service;

import com.example.rest.domain.CustomerDto;
import com.example.rest.domain.request.CustomerRequest;
import com.example.rest.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public List<CustomerDto> getCustomers() {
        return null;
    }

    public CustomerDto createCustomer(CustomerRequest request) {
        return null;
    }

    public void deleteCustomer(UUID customerId) {

    }

    public CustomerDto getCustomer(UUID customerId) {
        return null;
    }

    public CustomerDto updateCustomer(UUID customerId, CustomerRequest request) {
        return null;
    }
}

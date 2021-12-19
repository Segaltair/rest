package com.example.rest.controller;

import com.example.rest.domain.CustomerDto;
import com.example.rest.domain.request.CustomerRequest;
import com.example.rest.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;

    @GetMapping
    public List<CustomerDto> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping
    public CustomerDto createCustomer(
            @RequestBody CustomerRequest request
    ) {
        return customerService.createCustomer(request);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(
            @PathVariable UUID customerId
    ) {
        customerService.deleteCustomer(customerId);
    }

    @GetMapping("/{customerId}")
    public CustomerDto getCustomer(
            @PathVariable UUID customerId
    ) {
        return customerService.getCustomer(customerId);
    }

    @PutMapping("/{customerId}")
    public CustomerDto updateCustomer(
            @PathVariable UUID customerId,
            @RequestBody CustomerRequest request
    ) {
        return customerService.updateCustomer(customerId, request);
    }
}

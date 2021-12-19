package com.example.rest.controller;

import com.example.rest.domain.CustomerDto;
import com.example.rest.domain.request.CustomerRequest;
import com.example.rest.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;

    @GetMapping
    public Page<CustomerDto> getCustomers(Pageable pageable) {
        return customerService.getCustomers(pageable);
    }

    @PostMapping
    public CustomerDto createCustomer(
            @NotNull @Valid @RequestBody CustomerRequest request
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

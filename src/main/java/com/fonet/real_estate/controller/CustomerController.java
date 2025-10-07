package com.fonet.real_estate.controller;

import com.fonet.real_estate.entity.Customer;
import com.fonet.real_estate.service.CustomerService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@Positive @PathVariable("id") Long id) {
        return customerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @PutMapping("/{id}")
    public Customer replaceOrCreate(@Positive @PathVariable("id") Long id,
                                    @Validated @RequestBody Customer customer) {
        return customerService.replaceOrCreate(id,customer);
    }

    @PatchMapping("/{id}")
    public Customer update(@Positive @PathVariable("id") Long id,
                           @Validated @RequestBody Customer customer) {
        return customerService.update(id, customer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Positive @PathVariable("id") Long id) {
        customerService.deleteById(id);
    }

}

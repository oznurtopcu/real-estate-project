package com.fonet.real_estate.service;

import com.fonet.real_estate.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();
    Customer findById(Long id);
    Customer create(Customer customer);

    Customer replaceOrCreate(Long id, Customer customer);
    Customer update(Long id, Customer customer);

    void deleteById(Long id);
}

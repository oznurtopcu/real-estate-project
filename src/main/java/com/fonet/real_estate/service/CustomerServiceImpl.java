package com.fonet.real_estate.service;

import com.fonet.real_estate.entity.Company;
import com.fonet.real_estate.entity.Customer;
import com.fonet.real_estate.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    //TODO: exception
    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer replaceOrCreate(Long id, Customer customer) {

        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if(optionalCustomer.isPresent()) {

            customer.setId(id);

            return customerRepository.save(customer);
        }

        return customerRepository.save(customer);
    }

    //TODO: exception eklenecek
    @Override
    public Customer update(Long id, Customer customer) {

        Customer customerToUpdate = customerRepository.findById(id)
                .orElseThrow();


        if(customer.getFirstName() != null)
            customerToUpdate.setFirstName(customer.getFirstName());

        if(customer.getLastName() != null)
            customerToUpdate.setLastName(customer.getLastName());

        if(customer.getPhoneNumber() != null)
            customerToUpdate.setPhoneNumber(customer.getPhoneNumber());

        if(customer.getEmail() != null)
            customerToUpdate.setEmail(customer.getEmail());

        return customerRepository.save(customerToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}

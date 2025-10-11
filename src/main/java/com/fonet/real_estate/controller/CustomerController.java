package com.fonet.real_estate.controller;

import com.fonet.real_estate.dto.CustomerRequestDto;
import com.fonet.real_estate.dto.CustomerResponseDto;
import com.fonet.real_estate.dto.ListingResponseDto;
import com.fonet.real_estate.entity.Company;
import com.fonet.real_estate.entity.Customer;
import com.fonet.real_estate.service.CustomerService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerResponseDto> getAll() {

        return customerService.getAll()
                .stream()
                .map(customer -> new CustomerResponseDto(
                        customer.getId(),
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getPhoneNumber(),
                        customer.getEmail()))
                .toList();
    }

    @GetMapping("/{id}")
    public CustomerResponseDto getCustomerById(@Positive @PathVariable("id") Long id) {

        Customer customer = customerService.findById(id);

        CustomerResponseDto customerResponseDto = new CustomerResponseDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhoneNumber(),
                customer.getEmail());

        return customerResponseDto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDto create(@RequestBody CustomerRequestDto customerRequestDto) {

        Customer customer = new Customer();
        customer.setFirstName(customerRequestDto.getFirstName());
        customer.setLastName(customerRequestDto.getLastName());
        customer.setPhoneNumber(customerRequestDto.getPhoneNumber());
        customer.setEmail(customerRequestDto.getEmail());

        customer = customerService.create(customer);

        CustomerResponseDto customerResponseDto = new CustomerResponseDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhoneNumber(),
                customer.getEmail()
        );

        return customerResponseDto;
    }

    @PutMapping("/{id}")
    public CustomerResponseDto replaceOrCreate(@Positive @PathVariable("id") Long id,
                                    @Validated @RequestBody CustomerRequestDto customerRequestDto) {

        Customer customer = new Customer();
        customer.setFirstName(customerRequestDto.getFirstName());
        customer.setLastName(customerRequestDto.getLastName());
        customer.setPhoneNumber(customerRequestDto.getPhoneNumber());
        customer.setEmail(customerRequestDto.getEmail());

        customer = customerService.replaceOrCreate(id, customer);

        CustomerResponseDto customerResponseDto = new CustomerResponseDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhoneNumber(),
                customer.getEmail()
        );

        return customerResponseDto;
    }

    @PatchMapping("/{id}")
    public CustomerResponseDto update(@Positive @PathVariable("id") Long id,
                           @Validated @RequestBody CustomerRequestDto customerRequestDto) {

        Customer customer = new Customer();
        customer.setFirstName(customerRequestDto.getFirstName());
        customer.setLastName(customerRequestDto.getLastName());
        customer.setPhoneNumber(customerRequestDto.getPhoneNumber());
        customer.setEmail(customerRequestDto.getEmail());

        customer = customerService.update(id, customer);

        CustomerResponseDto customerResponseDto = new CustomerResponseDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhoneNumber(),
                customer.getEmail()
        );
        
        return customerResponseDto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Positive @PathVariable("id") Long id) {
        customerService.deleteById(id);
    }

    @GetMapping("/{id}/listings")
    public List<ListingResponseDto> getListingsForCustomerId(@Positive @PathVariable("id") Long id) {

        Customer customer = customerService.findById(id);

        return customer.getListings()
                .stream()
                .map(listing -> new ListingResponseDto(
                        listing.getType(),
                        listing.getRoomInfo(),
                        listing.getArea(),
                        listing.getFloor(),
                        listing.getBuildingFloor(),
                        listing.getHeatingType(),
                        listing.getPrice(),
                        listing.getDescription()))
                .toList();

    }


}

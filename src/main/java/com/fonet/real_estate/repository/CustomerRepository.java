package com.fonet.real_estate.repository;

import com.fonet.real_estate.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

package com.fonet.real_estate.repository;

import com.fonet.real_estate.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}

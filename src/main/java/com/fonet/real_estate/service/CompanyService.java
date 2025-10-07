package com.fonet.real_estate.service;

import com.fonet.real_estate.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAll();
    Company findById(Long id);
    Company create(Company company);

    Company replaceOrCreate(Long id, Company company);
    Company update(Long id, Company company);

    void deleteById(Long id);
}

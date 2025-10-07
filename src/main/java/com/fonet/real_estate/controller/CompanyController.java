package com.fonet.real_estate.controller;

import com.fonet.real_estate.entity.Company;
import com.fonet.real_estate.service.CompanyService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getCompanies() {
        return companyService.getAll();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@Positive @PathVariable("id") Long id) {
        return companyService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company create(@Validated @RequestBody Company company) {
        return companyService.create(company);
    }

    @PutMapping("/{id}")
    public Company replaceOrCreate(@Positive @PathVariable("id") Long id,
                                   @Validated @RequestBody Company company) {
        return companyService.replaceOrCreate(id, company);
    }

    @PatchMapping("/{id}")
    public Company update(@Positive @PathVariable("id") Long id,
                          @Validated @RequestBody Company company) {
        return companyService.update(id,company);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Positive @PathVariable("id") Long id) {
        companyService.deleteById(id);
    }

}

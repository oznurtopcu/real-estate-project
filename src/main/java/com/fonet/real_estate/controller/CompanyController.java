package com.fonet.real_estate.controller;

import com.fonet.real_estate.dto.CompanyPatchRequestDto;
import com.fonet.real_estate.dto.CompanyRequestDto;
import com.fonet.real_estate.dto.CompanyResponseDto;
import com.fonet.real_estate.dto.ListingResponseDto;
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
    public List<CompanyResponseDto> getCompanies() {

        //return companyService.getAll();
        //TODO: companyResponseDto dönüştürme işlemini farklı bir dosyaya taşı
        return companyService.getAll()
                .stream()
                .map(company -> new CompanyResponseDto(
                        company.getId(),
                        company.getName(),
                        company.getAddress(),
                        company.getPhoneNumber(),
                        company.getAuthorizedPerson()))
                .toList();
    }

    @GetMapping("/{id}")
    public CompanyResponseDto getCompanyById(@Positive @PathVariable("id") Long id) {

        Company company = companyService.findById(id);

        //TODO: companyResponseDto dönüştürme işlemini farklı bir dosyaya taşı
        CompanyResponseDto companyResponseDto = new CompanyResponseDto(
                company.getId(),
                company.getName(),
                company.getAddress(),
                company.getPhoneNumber(),
                company.getAuthorizedPerson());

        return companyResponseDto;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyResponseDto create(@Validated @RequestBody CompanyRequestDto companyRequestDto) {
        //return companyService.create(company);

        //TODO: companyRequestDto için ayrı bir fonksiyon yaz(başka bir dosyada)
        Company company = new Company();
        company.setName(companyRequestDto.getName());
        company.setAddress(companyRequestDto.getAddress());
        company.setPhoneNumber(companyRequestDto.getPhoneNumber());
        company.setAuthorizedPerson(companyRequestDto.getAuthorizedPerson());

        company = companyService.create(company);

        //TODO: companyResponseDto dönüştürme işlemini farklı bir dosyaya taşı
        CompanyResponseDto companyResponseDto = new CompanyResponseDto(
                company.getId(),
                company.getName(),
                company.getAddress(),
                company.getPhoneNumber(),
                company.getAuthorizedPerson());

        return companyResponseDto;
    }


    @PutMapping("/{id}")
    public CompanyResponseDto replaceOrCreate(@Positive @PathVariable("id") Long id,
                                              @Validated @RequestBody CompanyRequestDto companyRequestDto) {

        Company company = new Company();
        company.setName(companyRequestDto.getName());
        company.setAddress(companyRequestDto.getAddress());
        company.setPhoneNumber(companyRequestDto.getPhoneNumber());
        company.setAuthorizedPerson(companyRequestDto.getAuthorizedPerson());

        Company updatedCompany = companyService.replaceOrCreate(id, company);
        CompanyResponseDto companyResponseDto = new CompanyResponseDto(
                updatedCompany.getId(),
                updatedCompany.getName(),
                updatedCompany.getAddress(),
                updatedCompany.getPhoneNumber(),
                updatedCompany.getAuthorizedPerson());

        return companyResponseDto;
    }


    @PatchMapping("/{id}")
    public CompanyResponseDto update(@Positive @PathVariable("id") Long id,
                                     @Validated @RequestBody CompanyPatchRequestDto companyPatchRequestDto) {
        //return companyService.update(id,company);

        Company company = new Company();
        company.setName(companyPatchRequestDto.getName());
        company.setAddress(companyPatchRequestDto.getAddress());
        company.setPhoneNumber(companyPatchRequestDto.getPhoneNumber());
        company.setAuthorizedPerson(companyPatchRequestDto.getAuthorizedPerson());

        Company updatedCompany = companyService.update(id, company);
        CompanyResponseDto companyResponseDto = new CompanyResponseDto(
                updatedCompany.getId(),
                updatedCompany.getName(),
                updatedCompany.getAddress(),
                updatedCompany.getPhoneNumber(),
                updatedCompany.getAuthorizedPerson());

        return companyResponseDto;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Positive @PathVariable("id") Long id) {
        companyService.deleteById(id);
    }


    @GetMapping("/{id}/listings")
    public List<ListingResponseDto> getListingsForCompanyId(@Positive @PathVariable("id") Long id) {

        Company company = companyService.findById(id);

        return company.getListings()
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

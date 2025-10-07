package com.fonet.real_estate.service;

import com.fonet.real_estate.entity.Company;
import com.fonet.real_estate.exceptions.CompanyNotFoundException;
import com.fonet.real_estate.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    //TODO: exception handler eklenecek!!!
    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id + "ID'li şirket bulunamadı!"));
    }

    @Override
    public Company create(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company replaceOrCreate(Long id, Company company) {

        Optional<Company> optionalCompany = companyRepository.findById(id);

        if(optionalCompany.isPresent()) {
            company.setId(id);

            return companyRepository.save(company);
        }

        return companyRepository.save(company);
    }

    //TODO: exception handler eklenecek!!!
    @Override
    public Company update(Long id, Company company) {

        Company companyToUpdate = companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id + "ID'li şirket bulunamadı!"));

        if(company.getName() != null)
            companyToUpdate.setName(company.getName());

        if(company.getAddress() != null)
            companyToUpdate.setAddress(company.getAddress());

        if(company.getPhoneNumber() != null)
            companyToUpdate.setPhoneNumber(company.getPhoneNumber());

        if(company.getAuthorizedPerson() != null)
            companyToUpdate.setAuthorizedPerson(company.getAuthorizedPerson());

        return companyRepository.save(companyToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }
}

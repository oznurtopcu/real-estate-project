package com.fonet.real_estate.controller;

import com.fonet.real_estate.entity.RealEstate;
import com.fonet.real_estate.service.RealEstateService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/real-estate")
public class RealEstateController {

    private final RealEstateService realEstateService;

    @Autowired
    public RealEstateController(RealEstateService realEstateService) {
        this.realEstateService = realEstateService;
    }

    @GetMapping
    public List<RealEstate> getRealEstates() {
        return realEstateService.getAll();
    }

    @GetMapping("/{id}")
    public RealEstate getRealEstateById(@Positive @PathVariable("id") Long id) {
        return realEstateService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RealEstate create(@Validated @RequestBody RealEstate realEstate) {
        return realEstateService.create(realEstate);
    }

    @PutMapping("/{id}")
    public RealEstate replaceOrCreate(@Positive @PathVariable("id") Long id,
                                      @Validated @RequestBody RealEstate realEstate) {
        return realEstateService.replaceOrCreate(id, realEstate);
    }

    @PatchMapping("/{id}")
    public RealEstate update(@Positive @PathVariable("id") Long id,
                             @Validated @RequestBody RealEstate realEstate) {
        return realEstateService.update(id, realEstate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Positive @PathVariable("id") Long id) {
        realEstateService.deleteById(id);
    }

}

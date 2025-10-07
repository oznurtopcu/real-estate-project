package com.fonet.real_estate.service;

import com.fonet.real_estate.entity.RealEstate;

import java.util.List;

public interface RealEstateService {

    List<RealEstate> getAll();
    RealEstate findById(Long id);
    RealEstate create(RealEstate realEstate);

    RealEstate replaceOrCreate(Long id, RealEstate realEstate);
    RealEstate update(Long id, RealEstate realEstate);

    void deleteById(Long id);
}

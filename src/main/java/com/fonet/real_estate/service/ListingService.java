package com.fonet.real_estate.service;

import com.fonet.real_estate.entity.Listing;

import java.util.List;

public interface ListingService {

    List<Listing> getAll();
    Listing findById(Long id);
    Listing create(Listing listing);

    Listing replaceOrCreate(Long id, Listing listing);
    Listing update(Long id, Listing listing);

    void deleteById(Long id);
}

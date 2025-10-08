package com.fonet.real_estate.controller;

import com.fonet.real_estate.entity.Listing;
import com.fonet.real_estate.service.ListingService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listing")
public class ListingController {

    private final ListingService listingService;

    @Autowired
    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @GetMapping
    public List<Listing> getListings() {
        return listingService.getAll();
    }

    @GetMapping("/{id}")
    public Listing getListingById(@Positive @PathVariable("id") Long id) {
        return listingService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Listing create(@Validated @RequestBody Listing listing) {
        return listingService.create(listing);
    }

    @PutMapping("/{id}")
    public Listing replaceOrCreate(@Positive @PathVariable("id") Long id,
                                   @Validated @RequestBody Listing listing) {
        return listingService.replaceOrCreate(id, listing);
    }

    @PatchMapping("/{id}")
    public Listing update(@Positive @PathVariable("id") Long id,
                          @Validated @RequestBody Listing listing) {
        return listingService.update(id, listing);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Positive @PathVariable("id") Long id) {
        listingService.deleteById(id);
    }

}

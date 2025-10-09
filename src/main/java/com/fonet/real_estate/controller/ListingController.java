package com.fonet.real_estate.controller;

import com.fonet.real_estate.dto.ListingRequestDto;
import com.fonet.real_estate.dto.ListingResponseDto;
import com.fonet.real_estate.dto.ListingSearchRequestDto;
import com.fonet.real_estate.entity.Company;
import com.fonet.real_estate.entity.Customer;
import com.fonet.real_estate.entity.Listing;
import com.fonet.real_estate.service.CompanyService;
import com.fonet.real_estate.service.CustomerService;
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
    private final CompanyService companyService;
    private final CustomerService customerService;

    @Autowired
    public ListingController(ListingService listingService, CompanyService companyService, CustomerService customerService) {
        this.listingService = listingService;
        this.companyService = companyService;
        this.customerService = customerService;
    }

    @GetMapping
    public List<ListingResponseDto> getListings() {
        return listingService.getAll()
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

    @GetMapping("/{id}")
    public ListingResponseDto getListingById(@Positive @PathVariable("id") Long id) {

        Listing listing = listingService.findById(id);

        ListingResponseDto listingResponseDto = new ListingResponseDto(
                listing.getType(),
                listing.getRoomInfo(),
                listing.getArea(),
                listing.getFloor(),
                listing.getBuildingFloor(),
                listing.getHeatingType(),
                listing.getPrice(),
                listing.getDescription());

        return listingResponseDto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ListingResponseDto create(@Validated @RequestBody ListingRequestDto listingRequestDto) {

        Listing listing = new Listing();
        listing.setType(listingRequestDto.getType());
        listing.setRoomInfo(listingRequestDto.getRoomInfo());
        listing.setArea(listingRequestDto.getArea());
        listing.setFloor(listingRequestDto.getFloor());
        listing.setBuildingFloor(listingRequestDto.getBuildingFloor());
        listing.setHeatingType(listingRequestDto.getHeatingType());
        listing.setPrice(listingRequestDto.getPrice());
        listing.setDescription(listingRequestDto.getDescription());

        Company company = companyService.findById(listingRequestDto.getCompanyId());
        Customer customer = customerService.findById(listingRequestDto.getCustomerId());

        listing.setCompany(company);
        listing.setCustomer(customer);

        company.addListing(listing);
        customer.addListing(listing);

        listing = listingService.create(listing);

        ListingResponseDto listingResponseDto = new ListingResponseDto(
                listing.getType(),
                listing.getRoomInfo(),
                listing.getArea(),
                listing.getFloor(),
                listing.getBuildingFloor(),
                listing.getHeatingType(),
                listing.getPrice(),
                listing.getDescription());


        return listingResponseDto;
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

    @PostMapping("/search")
    public List<ListingResponseDto> searchListings(@RequestBody ListingSearchRequestDto listingSearchRequestDto) {

        return listingService.searchListings(listingSearchRequestDto)
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

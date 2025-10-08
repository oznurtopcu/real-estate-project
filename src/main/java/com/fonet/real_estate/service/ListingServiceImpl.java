package com.fonet.real_estate.service;

import com.fonet.real_estate.entity.Listing;
import com.fonet.real_estate.exceptions.ListingNotFoundException;
import com.fonet.real_estate.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;

    @Autowired
    public ListingServiceImpl(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    @Override
    public List<Listing> getAll() {
        return listingRepository.findAll();
    }

    @Override
    public Listing findById(Long id) {
        return listingRepository.findById(id)
                .orElseThrow(() -> new ListingNotFoundException(id + " ID'li ilan bulunamadı!"));
    }

    //TODO: relationlar için setleme işlemleri eklenecek !!!!!
    @Override
    public Listing create(Listing listing) {
        return listingRepository.save(listing);
    }

    @Override
    public Listing replaceOrCreate(Long id, Listing listing) {

        Optional<Listing> optionalListing = listingRepository.findById(id);

        if(optionalListing.isPresent()) {

            listing.setId(id);

            return listingRepository.save(listing);
        }
        return listingRepository.save(listing);
    }

    @Override
    public Listing update(Long id, Listing listing) {

        Listing listingToUpdate = listingRepository.findById(id)
                .orElseThrow(() -> new ListingNotFoundException(id + " ID'li ilan bulunamadı!"));

        if(listing.getType() != null)
            listingToUpdate.setType(listing.getType());

        if(listing.getRoomInfo() != null)
            listingToUpdate.setRoomInfo(listing.getRoomInfo());

        if(listing.getArea() != null)
            listingToUpdate.setArea(listing.getArea());

        if(listing.getFloor() != null)
            listingToUpdate.setFloor(listing.getFloor());

        if(listing.getBuildingFloor() != null)
            listingToUpdate.setBuildingFloor(listing.getBuildingFloor());

        if(listing.getHeatingType() != null)
            listingToUpdate.setHeatingType(listing.getHeatingType());

        if(listing.getPrice() != null)
            listingToUpdate.setPrice(listing.getPrice());

        if(listing.getDescription() != null)
            listingToUpdate.setDescription(listing.getDescription());

        return listingRepository.save(listingToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        listingRepository.deleteById(id);
    }
}

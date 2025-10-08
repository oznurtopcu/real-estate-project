package com.fonet.real_estate.repository;

import com.fonet.real_estate.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing, Long> {
}

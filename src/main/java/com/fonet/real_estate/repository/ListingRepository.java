package com.fonet.real_estate.repository;

import com.fonet.real_estate.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Long> {


    @Query("SELECT l FROM Listing l " +
            "WHERE (:type IS NULL OR l.type = :type) " +
            "AND (:roomInfo IS NULL OR l.roomInfo = :roomInfo) " +
            "AND (:heatingType IS NULL OR l.heatingType = :heatingType) " +
            "AND (:minPrice IS NULL OR l.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR l.price <= :maxPrice) " +
            "AND (:minArea IS NULL OR l.area >= :minArea) " +
            "AND (:maxArea IS NULL OR l.area <= :maxArea)")
    List<Listing> searchListings(
            @Param("type") String type,
            @Param("roomInfo") String roomInfo,
            @Param("heatingType") String heatingType,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
            @Param("minArea") Double minArea,
            @Param("maxArea") Double maxArea
    );



}

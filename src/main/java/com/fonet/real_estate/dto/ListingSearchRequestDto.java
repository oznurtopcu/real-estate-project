package com.fonet.real_estate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListingSearchRequestDto {

    private String type;
    private String roomInfo;
    private String heatingType;
    private Double minPrice;
    private Double maxPrice;
    private Double minArea;
    private Double maxArea;

}

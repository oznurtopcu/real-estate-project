package com.fonet.real_estate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListingRequestDto {

    private String type;

    @JsonProperty(value = "room_info")
    private String roomInfo;

    private Double area;

    private Integer floor;

    @JsonProperty(value = "building_floor")
    private Integer buildingFloor;

    @JsonProperty(value = "heating_type")
    private String heatingType;

    private Double price;

    private String description;

    @JsonProperty(value = "company_id")
    private Long companyId;

    @JsonProperty(value = "customer_id")
    private Long customerId;

}

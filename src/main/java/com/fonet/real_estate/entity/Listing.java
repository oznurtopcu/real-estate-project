package com.fonet.real_estate.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "listing", schema = "real_estate")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //ENUM yapılabilir
    private String type;

    @JsonProperty(value = "room_info")
    private String roomInfo;

    private Double area;

    private Integer floor;

    @Column(name = "building_floor")
    private Integer buildingFloor;

    @Column(name = "heating_type")
    private String heatingType;

    private Double price;

    private String description;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;


    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj == null || obj.getClass() != this.getClass())
            return false;

        Listing listing = (Listing) obj;

        return listing.getId().equals(this.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }
}

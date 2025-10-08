package com.fonet.real_estate.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company", schema = "real_estate")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(max = 150)
    private String name;

    private String address;

    @Size(max = 30)
    @Column(name = "phone_number")
    @JsonProperty(value = "phone_number")
    private String phoneNumber;

    @Size(max = 70)
    @Column(name = "authorized_person")
    @JsonProperty(value = "authorized_person")
    private String authorizedPerson;


    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Listing> listings;

    private void addListing(Listing listing) {

        if(listings == null)
            listings = new HashSet<>();

        listings.add(listing);
    }

}

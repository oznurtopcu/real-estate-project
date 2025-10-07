package com.fonet.real_estate.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "customer", schema = "real_estate")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(max = 45)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(max = 45)
    @Column(name = "last_name")
    private String lastName;

    @Size(max = 30)
    @Column(name = "phone_number")
    private String phoneNumber;

    @Email
    @Size(max = 100)
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<RealEstate> realEstates;

    private void addRealEstate(RealEstate realEstate) {

        if(realEstates == null)
            realEstates = new HashSet<>();

        realEstates.add(realEstate);
    }
}

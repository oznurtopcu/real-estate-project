package com.fonet.real_estate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyPatchRequestDto {

    @Size(max = 150)
    private String name;

    @Size(max = 255)
    private String address;

    @Size(max = 30)
    @JsonProperty(value = "phone_number")
    private String phoneNumber;

    @Size(max = 70)
    @JsonProperty(value = "authorized_person")
    private String authorizedPerson;

}

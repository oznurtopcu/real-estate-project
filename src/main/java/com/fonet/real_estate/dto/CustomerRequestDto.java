package com.fonet.real_estate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
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
public class CustomerRequestDto {


    @NotNull
    @NotEmpty
    @Size(max = 45)
    @JsonProperty(value = "first_name")
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(max = 45)
    @JsonProperty(value = "last_name")
    private String lastName;

    @Size(max = 30)
    @JsonProperty(value = "phone_number")
    private String phoneNumber;

    @Email
    @Size(max = 100)
    private String email;

}

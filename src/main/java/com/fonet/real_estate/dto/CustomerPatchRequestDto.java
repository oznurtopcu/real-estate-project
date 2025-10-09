package com.fonet.real_estate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class CustomerPatchRequestDto {

    @Size(max = 45, message = "45 karakterden fazla olamaz!")
    @JsonProperty(value = "first_name")
    private String firstName;

    @Size(max = 45, message = "45 karakterden fazla olamaz!")
    @JsonProperty(value = "last_name")
    private String lastName;

    @Size(max = 30, message = "30 karakterden fazla olamaz!")
    @JsonProperty(value = "phone_number")
    private String phoneNumber;

    @Email
    @Size(max = 100, message = "100 karakterden fazla olamaz!")
    private String email;
}

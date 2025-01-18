package br.com.alura.med.voll.api.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(

        @NotBlank
        String street,

        @NotBlank
        String neighborhood,

        @NotBlank
        @Pattern(regexp = "\\d{5,9}")
        String zip,

        @NotBlank
        String city,

        @NotBlank
        String state,

        String complement,

        String number
) {
}

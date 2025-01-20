package br.com.alura.med.voll.api.dto.patient;

import br.com.alura.med.voll.api.dto.address.AddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PatientDTO(

        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String phone,

        @NotBlank
        String ssn,

        @NotNull
        @Valid
        AddressDTO address
) {
}

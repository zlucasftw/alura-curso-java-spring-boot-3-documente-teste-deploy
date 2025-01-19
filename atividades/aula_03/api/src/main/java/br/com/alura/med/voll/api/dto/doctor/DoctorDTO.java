package br.com.alura.med.voll.api.dto.doctor;

import br.com.alura.med.voll.api.dto.address.AddressDTO;
import br.com.alura.med.voll.api.enums.doctor.Specialty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DoctorDTO(
        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String phone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String md,

        @NotNull
        Specialty specialty,

        @NotNull
        @Valid
        AddressDTO address
) {
}

package br.com.alura.med.voll.api.dto.patient;

import br.com.alura.med.voll.api.dto.address.AddressDTO;
import jakarta.validation.constraints.NotNull;

public record PatientUpdateDTO(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressDTO address
) {
}

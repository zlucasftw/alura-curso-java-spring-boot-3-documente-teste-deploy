package br.com.alura.med.voll.api.dto.doctor;

import br.com.alura.med.voll.api.dto.address.AddressDTO;
import jakarta.validation.constraints.NotNull;

public record DoctorUpdateDTO(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressDTO address
) {
}

package br.com.alura.med.voll.api.dto.patient;

import br.com.alura.med.voll.api.entity.address.AddressEntity;
import br.com.alura.med.voll.api.entity.patient.PatientEntity;

public record PatientDetailsDTO(
        Long id, String name, String email, String phone,
        String ssn, AddressEntity address) {

    public PatientDetailsDTO(PatientEntity data) {
        this(data.getId(), data.getName(), data.getEmail(), data.getPhone(),
                data.getSsn(), data.getAddress());
    }

}

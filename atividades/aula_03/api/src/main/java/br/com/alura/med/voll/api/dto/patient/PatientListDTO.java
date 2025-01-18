package br.com.alura.med.voll.api.dto.patient;

import br.com.alura.med.voll.api.entity.patient.PatientEntity;

public record PatientListDTO(Long id, String name, String email, String ssn) {
    public PatientListDTO(PatientEntity patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getSsn());
    }
}

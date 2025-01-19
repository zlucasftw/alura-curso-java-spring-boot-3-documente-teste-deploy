package br.com.alura.med.voll.api.dto.doctor;

import br.com.alura.med.voll.api.entity.doctor.DoctorEntity;
import br.com.alura.med.voll.api.enums.doctor.Specialty;

public record DoctorListDTO(Long id, String name, String email, String md, Specialty specialty) {

    public DoctorListDTO(DoctorEntity doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getMd(), doctor.getSpecialty());
    }
}

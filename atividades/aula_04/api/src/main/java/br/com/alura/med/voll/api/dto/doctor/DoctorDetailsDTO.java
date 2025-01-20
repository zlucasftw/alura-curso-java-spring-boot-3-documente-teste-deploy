package br.com.alura.med.voll.api.dto.doctor;

import br.com.alura.med.voll.api.entity.address.AddressEntity;
import br.com.alura.med.voll.api.entity.doctor.DoctorEntity;
import br.com.alura.med.voll.api.enums.doctor.Specialty;

public record DoctorDetailsDTO(
        Long id,
        String name,
        String email,
        String phone,
        String md,
        Specialty specialty,
        AddressEntity address) {

    public DoctorDetailsDTO(DoctorEntity data) {
        this(data.getId(), data.getName(), data.getEmail(), data.getPhone(),
                data.getMd(), data.getSpecialty(), data.getAddress());
    }
}

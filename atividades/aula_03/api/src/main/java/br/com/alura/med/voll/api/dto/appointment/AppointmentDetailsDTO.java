package br.com.alura.med.voll.api.dto.appointment;

import br.com.alura.med.voll.api.entity.appointment.AppointmentEntity;

import java.time.LocalDateTime;

public record AppointmentDetailsDTO(Long id, Long doctorId, Long patientId, LocalDateTime date) {
    public AppointmentDetailsDTO(AppointmentEntity appointment) {
        this(appointment.getId(), appointment.getDoctor().getId(), appointment.getPatient().getId(), appointment.getDate());
    }
}

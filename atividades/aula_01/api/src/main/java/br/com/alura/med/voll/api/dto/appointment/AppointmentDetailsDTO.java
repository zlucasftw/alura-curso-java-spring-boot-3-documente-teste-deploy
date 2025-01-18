package br.com.alura.med.voll.api.dto.appointment;

import java.time.LocalDateTime;

public record AppointmentDetailsDTO(Long id, Long doctorId, Long patientId, LocalDateTime date) {}

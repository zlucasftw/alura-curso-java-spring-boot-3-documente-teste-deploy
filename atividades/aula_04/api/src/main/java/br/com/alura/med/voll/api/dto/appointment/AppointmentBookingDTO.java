package br.com.alura.med.voll.api.dto.appointment;

import br.com.alura.med.voll.api.enums.doctor.Specialty;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AppointmentBookingDTO(
        Long doctorId,

        @NotNull
        Long patientId,

        @NotNull
        @Future
        LocalDateTime date,

        Specialty specialty) {
}

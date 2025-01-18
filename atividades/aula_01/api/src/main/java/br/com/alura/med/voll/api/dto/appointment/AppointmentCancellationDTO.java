package br.com.alura.med.voll.api.dto.appointment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AppointmentCancellationDTO(@NotBlank String cancellationReason) {
}

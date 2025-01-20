package br.com.alura.med.voll.api.service.appointment.validation;

import br.com.alura.med.voll.api.dto.appointment.AppointmentBookingDTO;
import br.com.alura.med.voll.api.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class AppointmentTimeInAdvanceValidation implements IAppointmentBookingValidation {

    @Override
    public void appointmentValidation(AppointmentBookingDTO data) {
        var appointmentDate = data.date();
        var dateNow = LocalDateTime.now();

        var dateDifferenceInMinutes = Duration.between(dateNow, appointmentDate).toMinutes();

        if (dateDifferenceInMinutes < 30) {
            throw new ValidationException("Appointment must be booked with 30 minutes minimum in advance.");
        }

    }

}

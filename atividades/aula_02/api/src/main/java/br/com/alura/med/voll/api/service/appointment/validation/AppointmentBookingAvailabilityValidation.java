package br.com.alura.med.voll.api.service.appointment.validation;

import br.com.alura.med.voll.api.dto.appointment.AppointmentBookingDTO;
import br.com.alura.med.voll.api.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class AppointmentBookingAvailabilityValidation implements IAppointmentBookingValidation {

    @Override
    public void appointmentValidation(AppointmentBookingDTO data) {

        var bookingDate = data.date();

        var bookingDateIsSunday = bookingDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var dataIsBeforeBookingAvailability = bookingDate.getHour() < 7;
        var dataIsAfterBookingAvailability = bookingDate.getHour() > 18;

        if (bookingDateIsSunday || dataIsBeforeBookingAvailability || dataIsAfterBookingAvailability) {
            throw new ValidationException("Appointment out of booking availability.");
        }

    }

}

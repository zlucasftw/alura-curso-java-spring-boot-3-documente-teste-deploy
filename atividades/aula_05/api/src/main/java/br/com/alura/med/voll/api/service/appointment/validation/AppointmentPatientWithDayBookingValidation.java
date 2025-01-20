package br.com.alura.med.voll.api.service.appointment.validation;

import br.com.alura.med.voll.api.dto.appointment.AppointmentBookingDTO;
import br.com.alura.med.voll.api.exception.ValidationException;
import br.com.alura.med.voll.api.repository.appointment.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentPatientWithDayBookingValidation implements IAppointmentBookingValidation {

    @Autowired
    private AppointmentRepository repository;

    @Override
    public void appointmentValidation(AppointmentBookingDTO data) {
        var firstPossibleBookingHour = data.date().withHour(7);
        var lastPossibleBookingHour = data.date().withHour(18);

        var isPatientWithBookingAtSameDay = this.repository.existsByPatientIdAndDateBetween(data.patientId(),
                firstPossibleBookingHour, lastPossibleBookingHour);

        if (isPatientWithBookingAtSameDay) {
            throw new ValidationException("Patient with appointment already booked for the same day.");
        }
    }
}

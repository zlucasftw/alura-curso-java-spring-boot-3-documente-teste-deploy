package br.com.alura.med.voll.api.service.appointment.validation;

import br.com.alura.med.voll.api.dto.appointment.AppointmentBookingDTO;
import br.com.alura.med.voll.api.exception.ValidationException;
import br.com.alura.med.voll.api.repository.appointment.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentWithSameTimeValidation implements IAppointmentBookingValidation {

    @Autowired
    private AppointmentRepository repository;

    @Override
    public void appointmentValidation(AppointmentBookingDTO data) {
        var isDoctorWithAppointment = this.repository.existsByDoctorIdAndDate(data.doctorId(), data.date());
        if (isDoctorWithAppointment) {
            throw new ValidationException("Doctor with an appointment already booked for the given date.");
        }
    }

}

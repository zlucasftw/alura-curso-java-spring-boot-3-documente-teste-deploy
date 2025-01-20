package br.com.alura.med.voll.api.service.appointment.validation;

import br.com.alura.med.voll.api.dto.appointment.AppointmentBookingDTO;
import br.com.alura.med.voll.api.exception.ValidationException;
import br.com.alura.med.voll.api.repository.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentActiveDoctorValidation implements IAppointmentBookingValidation {

    @Autowired
    private DoctorRepository repository;

    @Override
    public void appointmentValidation(AppointmentBookingDTO data) {
        // This checks if the choice of a specific doctor was made.
        if (data.doctorId() == null) {
            return;
        }

        var isDoctorActive = this.repository.findActiveById(data.doctorId());
        if (!isDoctorActive) {
            throw new ValidationException("Appointment can't be booked with non existing doctor.");
        }
    }

}

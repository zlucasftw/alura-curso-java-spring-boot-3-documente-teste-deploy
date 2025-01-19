package br.com.alura.med.voll.api.service.appointment.validation;

import br.com.alura.med.voll.api.dto.appointment.AppointmentBookingDTO;
import br.com.alura.med.voll.api.repository.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentActivePatientValidation implements IAppointmentBookingValidation {

    @Autowired
    private PatientRepository repository;

    @Override
    public void appointmentValidation(AppointmentBookingDTO data) {
        var isPatientActive = this.repository.findActiveById(data.patientId());
    }
}

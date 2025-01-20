package br.com.alura.med.voll.api.service.appointment.validation;

import br.com.alura.med.voll.api.dto.appointment.AppointmentBookingDTO;

public interface IAppointmentBookingValidation {

    void appointmentValidation(AppointmentBookingDTO data);

}

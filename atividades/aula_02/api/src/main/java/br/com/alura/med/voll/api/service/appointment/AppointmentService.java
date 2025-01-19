package br.com.alura.med.voll.api.service.appointment;

import br.com.alura.med.voll.api.dto.appointment.AppointmentCancellationDTO;
import br.com.alura.med.voll.api.dto.appointment.AppointmentDetailsDTO;
import br.com.alura.med.voll.api.enums.doctor.CancellationReason;
import br.com.alura.med.voll.api.repository.appointment.AppointmentRepository;
import br.com.alura.med.voll.api.dto.appointment.AppointmentBookingDTO;
import br.com.alura.med.voll.api.entity.appointment.AppointmentEntity;
import br.com.alura.med.voll.api.entity.doctor.DoctorEntity;
import br.com.alura.med.voll.api.exception.ValidationException;
import br.com.alura.med.voll.api.repository.doctor.DoctorRepository;
import br.com.alura.med.voll.api.repository.patient.PatientRepository;
import br.com.alura.med.voll.api.service.appointment.validation.IAppointmentBookingValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private List<IAppointmentBookingValidation> validations;

    public AppointmentDetailsDTO scheduleAppointment(AppointmentBookingDTO data) {

        if (!this.patientRepository.existsById(data.patientId())) {
            throw new ValidationException("Non-existent patient ID provided!");
        }

        if (data.doctorId() != null && !this.doctorRepository.existsById(data.doctorId())) {
            throw new ValidationException("Non-existent doctor ID provided!");
        }

        this.validations.forEach(v -> v.appointmentValidation(data));

        var patient = this.patientRepository.getReferenceById(data.patientId());
        var doctor = this.chooseDoctorRandomly(data);

        if (doctor == null) {
            throw new ValidationException("No doctor avaible at the given date.");
        }

        var appointment = new AppointmentEntity(null, doctor, patient, data.date(), null, false);
        this.appointmentRepository.save(appointment);

        return new AppointmentDetailsDTO(appointment);
    }

    private DoctorEntity chooseDoctorRandomly(AppointmentBookingDTO data) {

        if (data.doctorId() != null) {
            return this.doctorRepository.getReferenceById(data.doctorId());
        }

        if (data.specialty() == null) {
            throw new ValidationException("Required specialty of doctor if not chosen.");
        }

        return this.doctorRepository.chooseRandomAvailableDoctor(data.specialty(), data.date());
    }

    public void cancelAppointment(AppointmentCancellationDTO data) {

        if (!this.appointmentRepository.existsById(data.appointmentId())) {
            throw new ValidationException("Invalid appointment ID given.");
        }

        var appointment = this.appointmentRepository.getReferenceById(data.appointmentId());
        var currentDateHour = LocalDateTime.now();
        var appointmentCancellationHours = Duration.between(currentDateHour, appointment.getDate()).toHours();

        if (appointmentCancellationHours < 24) {
            throw new ValidationException("Cancellation require to be at least 24 hours before appointment.");
        }

        // var appointment = this.appointmentRepository.getReferenceById(data.appointmentId());
        appointment.cancelAppointment(CancellationReason.fromText(data.cancellationReason()));

        // throw new ValidationException("Invalid appointment cancellation reason.");

    }

}

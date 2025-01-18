package br.com.alura.med.voll.api.service.appointment;

import br.com.alura.med.voll.api.dto.appointment.AppointmentCancellationDTO;
import br.com.alura.med.voll.api.enums.doctor.CancellationReason;
import br.com.alura.med.voll.api.repository.appointment.AppointmentRepository;
import br.com.alura.med.voll.api.dto.appointment.AppointmentBookingDTO;
import br.com.alura.med.voll.api.entity.appointment.AppointmentEntity;
import br.com.alura.med.voll.api.entity.doctor.DoctorEntity;
import br.com.alura.med.voll.api.exception.ValidationException;
import br.com.alura.med.voll.api.repository.doctor.DoctorRepository;
import br.com.alura.med.voll.api.repository.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    public void scheduleAppointment(AppointmentBookingDTO data) {

        if (!this.patientRepository.existsById(data.patientId())) {
            throw new ValidationException("Non-existent patient ID provided");
        }

        if (data.doctorId() != null && !this.doctorRepository.existsById(data.doctorId())) {
            throw new ValidationException("Non-existent doctor ID provided!");
        }

        var patient = this.patientRepository.getReferenceById(data.patientId());
        var doctor = chooseDoctorRandomly(data);
        var appointment = new AppointmentEntity(null, doctor, patient, data.date(), false);
        this.appointmentRepository.save(appointment);
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

    public void cancelAppointment(AppointmentCancellationDTO data, Long id) {
        var appointment = this.appointmentRepository.getReferenceById(id);
        if (data.cancellationReason().equalsIgnoreCase(CancellationReason.values().toString())) {
            appointment.cancelAppointment();
        } else {
            throw new ValidationException("Invalid appointment cancellation reason.");
        }
    }

}

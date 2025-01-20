package br.com.alura.med.voll.api.repository.appointment;

import br.com.alura.med.voll.api.entity.appointment.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

    Boolean existsByPatientIdAndDateBetween(Long patientId, LocalDateTime firstDate, LocalDateTime lastDate);

    Boolean existsByDoctorIdAndDate(Long doctorId, LocalDateTime date);
}

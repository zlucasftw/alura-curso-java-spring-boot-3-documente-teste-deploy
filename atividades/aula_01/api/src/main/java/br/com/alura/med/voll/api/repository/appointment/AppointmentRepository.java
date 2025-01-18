package br.com.alura.med.voll.api.repository.appointment;

import br.com.alura.med.voll.api.entity.appointment.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
}

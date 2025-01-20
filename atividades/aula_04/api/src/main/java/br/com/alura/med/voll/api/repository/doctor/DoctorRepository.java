package br.com.alura.med.voll.api.repository.doctor;

import br.com.alura.med.voll.api.entity.doctor.DoctorEntity;
import br.com.alura.med.voll.api.enums.doctor.Specialty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
    Page<DoctorEntity> findAllByActiveTrue(Pageable pagination);

    @Query("""
            SELECT d
            FROM Doctor d
            WHERE d.active = TRUE AND d.specialty = :specialty
            AND d.id NOT IN (SELECT a.doctor.id
                        FROM Appointment a
                        WHERE a.date = :date)
            ORDER BY RAND()
            LIMIT 1
            """)
    DoctorEntity chooseRandomAvailableDoctor(Specialty specialty, LocalDateTime date);

    @Query("""
            SELECT m.active
            FROM Doctor m
            WHERE m.id = :id
            """)
    Boolean findActiveById(Long id);
}

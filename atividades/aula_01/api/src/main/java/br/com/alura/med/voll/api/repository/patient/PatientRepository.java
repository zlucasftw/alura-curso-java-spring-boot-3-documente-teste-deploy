package br.com.alura.med.voll.api.repository.patient;

import br.com.alura.med.voll.api.entity.patient.PatientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    Page<PatientEntity> findAllByActiveTrue(Pageable pagination);
}

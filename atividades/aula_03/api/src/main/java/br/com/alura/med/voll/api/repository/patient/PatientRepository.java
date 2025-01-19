package br.com.alura.med.voll.api.repository.patient;

import br.com.alura.med.voll.api.entity.patient.PatientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    Page<PatientEntity> findAllByActiveTrue(Pageable pagination);

    @Query("""
        SELECT p.active
        FROM Patient p
        WHERE p.id = :id
        """)
    Boolean findActiveById(Long id);
}

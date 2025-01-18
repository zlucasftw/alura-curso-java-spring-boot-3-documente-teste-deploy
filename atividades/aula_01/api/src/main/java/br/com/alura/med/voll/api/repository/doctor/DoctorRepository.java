package br.com.alura.med.voll.api.repository.doctor;

import br.com.alura.med.voll.api.entity.doctor.DoctorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
    Page<DoctorEntity> findAllByActiveTrue(Pageable pagination);
}

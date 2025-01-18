package br.com.alura.med.voll.api.controller.doctor;

import br.com.alura.med.voll.api.dto.doctor.DoctorDTO;
import br.com.alura.med.voll.api.dto.doctor.DoctorDetailslDTO;
import br.com.alura.med.voll.api.dto.doctor.DoctorListDTO;
import br.com.alura.med.voll.api.dto.doctor.DoctorUpdateDTO;
import br.com.alura.med.voll.api.entity.doctor.DoctorEntity;
import br.com.alura.med.voll.api.repository.doctor.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DoctorDetailslDTO> registerDoctor(@RequestBody @Valid DoctorDTO data, UriComponentsBuilder uriBuilder) {
        var doctor = new DoctorEntity(data);
        this.repository.save(doctor);

        final var URI = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();

        return ResponseEntity.created(URI).body(new DoctorDetailslDTO(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorListDTO>> listDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var pages = this.repository.findAllByActiveTrue(pagination).map(DoctorListDTO::new);
        return ResponseEntity.ok(pages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDetailslDTO> getDoctorDetailsById(@PathVariable Long id) {
        var doctor = this.repository.getReferenceById(id);
        return ResponseEntity.ok(new DoctorDetailslDTO(doctor));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DoctorDetailslDTO> updateDoctor(@RequestBody @Valid DoctorUpdateDTO data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.updateData(data);

        return ResponseEntity.ok(new DoctorDetailslDTO(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteDoctor(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.deleteDoctor();
        return ResponseEntity.noContent().build();
    }

}

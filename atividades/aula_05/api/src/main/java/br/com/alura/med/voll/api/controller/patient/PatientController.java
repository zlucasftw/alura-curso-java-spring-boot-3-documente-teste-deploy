package br.com.alura.med.voll.api.controller.patient;

import br.com.alura.med.voll.api.dto.patient.PatientDTO;
import br.com.alura.med.voll.api.dto.patient.PatientDetailsDTO;
import br.com.alura.med.voll.api.dto.patient.PatientListDTO;
import br.com.alura.med.voll.api.dto.patient.PatientUpdateDTO;
import br.com.alura.med.voll.api.entity.patient.PatientEntity;
import br.com.alura.med.voll.api.repository.patient.PatientRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/patients")
@SecurityRequirement(name = "bearer-key")
public class PatientController {

    @Autowired
    PatientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<PatientDetailsDTO> registerPatient(@RequestBody @Valid PatientDTO data, UriComponentsBuilder uriBuilder) {
        var patient = new PatientEntity(data);
        this.repository.save(patient);

        final var URI = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(URI).body(new PatientDetailsDTO(patient));
    }

    @GetMapping
    public ResponseEntity<Page<PatientListDTO>> listPatients
            (@PageableDefault(size = 10, sort = {"name"}, direction = Sort.Direction.ASC) Pageable pagination) {

        var pages = this.repository.findAllByActiveTrue(pagination).map(PatientListDTO::new);
        return ResponseEntity.ok(pages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDetailsDTO> getPatientDetailsById(@PathVariable Long id) {
        var patient = this.repository.getReferenceById(id);
        return ResponseEntity.ok(new PatientDetailsDTO(patient));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<PatientDetailsDTO> updatePatient(@RequestBody @Valid PatientUpdateDTO data) {
        var patient = repository.getReferenceById(data.id());
        patient.updateData(data);

        return ResponseEntity.ok(new PatientDetailsDTO(patient));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePatient(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);
        patient.deleteData();
        return ResponseEntity.noContent().build();
    }

}

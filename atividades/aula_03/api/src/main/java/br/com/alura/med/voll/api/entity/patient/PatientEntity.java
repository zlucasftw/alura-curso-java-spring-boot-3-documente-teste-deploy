package br.com.alura.med.voll.api.entity.patient;

import br.com.alura.med.voll.api.dto.patient.PatientDTO;
import br.com.alura.med.voll.api.dto.patient.PatientUpdateDTO;
import br.com.alura.med.voll.api.entity.address.AddressEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Patient")
@Table(name = "patient")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String ssn;

    @Embedded
    private AddressEntity address;

    private Boolean active;

    public PatientEntity(PatientDTO data) {
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.ssn = data.ssn();
        this.address = new AddressEntity(data.address());
        this.active = true;
    }

    public void updateData(PatientUpdateDTO data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.phone() != null) {
            this.phone = data.phone();
        }
        if (data.address() != null) {
            this.address.updateAddress(data.address());
        }
    }

    public void deleteData() {
        this.active = false;
    }
}

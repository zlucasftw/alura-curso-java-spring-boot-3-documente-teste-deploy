package br.com.alura.med.voll.api.entity.doctor;

import br.com.alura.med.voll.api.dto.doctor.DoctorDTO;
import br.com.alura.med.voll.api.dto.doctor.DoctorUpdateDTO;
import br.com.alura.med.voll.api.entity.address.AddressEntity;
import br.com.alura.med.voll.api.enums.doctor.Specialty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "doctor")
@Table(name = "doctor")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String md;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private AddressEntity address;

    private Boolean active;

    public DoctorEntity(DoctorDTO data) {
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.md = data.md();
        this.specialty = data.specialty();
        this.address = new AddressEntity(data.address());
        this.active = true;
    }

    public void updateData(DoctorUpdateDTO data) {
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

    public void deleteDoctor() {
        this.active = false;
    }
}

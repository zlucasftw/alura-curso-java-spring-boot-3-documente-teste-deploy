package br.com.alura.med.voll.api.entity.address;

import br.com.alura.med.voll.api.dto.address.AddressDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AddressEntity {

    private String street;
    private String neighborhood;
    private String zip;
    private String number;
    private String state;
    private String complement;
    private String city;


    public AddressEntity(AddressDTO data) {
        this.street = data.street();
        this.neighborhood = data.neighborhood();
        this.zip = data.zip();
        this.number = data.number();
        this.state = data.state();
        this.complement = data.complement();
        this.city = data.city();
    }

    public void updateAddress(AddressDTO data) {
        if (data.street() != null) {
            this.street = data.street();
        }
        if (data.neighborhood() != null) {
            this.neighborhood = data.neighborhood();
        }
        if (data.zip() != null) {
            this.zip = data.zip();
        }
        if (data.number() != null) {
            this.number = data.number();
        }
        if (data.state() != null) {
            this.street = data.state();
        }
        if (data.complement() != null) {
            this.complement = data.complement();
        }
        if (this.city != null) {
            this.city = data.city();
        }
    }

}

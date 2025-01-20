package br.com.alura.med.voll.api.controller.doctor;

import br.com.alura.med.voll.api.dto.address.AddressDTO;
import br.com.alura.med.voll.api.dto.doctor.DoctorDTO;
import br.com.alura.med.voll.api.dto.doctor.DoctorDetailsDTO;
import br.com.alura.med.voll.api.entity.address.AddressEntity;
import br.com.alura.med.voll.api.entity.doctor.DoctorEntity;
import br.com.alura.med.voll.api.enums.doctor.Specialty;
import br.com.alura.med.voll.api.repository.doctor.DoctorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class DoctorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DoctorDTO> doctorDtoJson;

    @Autowired
    private JacksonTester<DoctorDetailsDTO> doctorDetailsDtoJson;

    @MockitoBean
    private DoctorRepository doctorRepository;

    @Test
    @WithMockUser
    @DisplayName("Should return HTTP status code 400 if invalid information received.")
    void registerDoctorFirstCase() throws Exception {

        var response = this.mvc.perform(post("/doctors"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @WithMockUser
    @DisplayName("Should return HTTP status code 201 if valid information received.")
    void registerDoctorSecondCase() throws Exception {
        var addressDto = new AddressDTO("Stret", "Neighborhood", "123456",
                "City", "State", null, null);

        var registeredDoctor = new DoctorDTO("Name", "test@api.com",
                "111111", "111111", Specialty.CARDIOLOGY, addressDto);

        when(this.doctorRepository.save(any())).thenReturn(new DoctorEntity(registeredDoctor));

        var response = this.mvc
                .perform(
                    post("/doctors")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(this.doctorDtoJson.write(
                                    registeredDoctor
                            ).getJson())
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

        var expectedJson = this.doctorDetailsDtoJson.write(
            new DoctorDetailsDTO(
                    null,
                    registeredDoctor.name(),
                    registeredDoctor.email(),
                    registeredDoctor.md(),
                    registeredDoctor.phone(),
                    registeredDoctor.specialty(),
                    new AddressEntity(addressDto))
        ).getJson();

        assertThat(response.getContentAsString()).isEqualTo(expectedJson);

    }

}
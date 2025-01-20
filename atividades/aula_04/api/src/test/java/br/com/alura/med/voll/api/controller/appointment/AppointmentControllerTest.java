package br.com.alura.med.voll.api.controller.appointment;

import br.com.alura.med.voll.api.dto.appointment.AppointmentBookingDTO;
import br.com.alura.med.voll.api.dto.appointment.AppointmentDetailsDTO;
import br.com.alura.med.voll.api.enums.doctor.Specialty;
import br.com.alura.med.voll.api.service.appointment.AppointmentService;
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

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class AppointmentControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<AppointmentBookingDTO> appointmentBookingDtoJson;

    @Autowired
    private JacksonTester<AppointmentDetailsDTO> appointmentBookingDetailsDtoJson;

    @MockitoBean
    private AppointmentService appointmentService;

    @Test
    @WithMockUser
    @DisplayName("Should return HTTP status code 400 if invalid information received.")
    void scheduleAppointmentFirstCase() throws Exception {
        var response = this.mvc.perform(post("/appointments"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @WithMockUser
    @DisplayName("Should return HTTP status code 200 if valid information received.")
    void scheduleAppointmentSecondCase() throws Exception {
        var date = LocalDateTime.now().plusHours(1);
        var specialty = Specialty.CARDIOLOGY;

        var appointmentDetails = new AppointmentDetailsDTO(null, 2L, 5L, date);
        when(this.appointmentService.scheduleAppointment(any())).thenReturn(appointmentDetails);

        var response = this.mvc
                .perform(
                        post("/appointments")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.appointmentBookingDtoJson.write(
                                        new AppointmentBookingDTO(2L, 5L, date, specialty)
                                ).getJson())
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        var expectedJson = this.appointmentBookingDetailsDtoJson.write(
                appointmentDetails
        ).getJson();

        assertThat(response.getContentAsString()).isEqualTo(expectedJson);
    }

}
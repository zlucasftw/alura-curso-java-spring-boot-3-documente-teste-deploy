package br.com.alura.med.voll.api.controller.appointment;

import br.com.alura.med.voll.api.dto.appointment.AppointmentBookingDTO;
import br.com.alura.med.voll.api.dto.appointment.AppointmentCancellationDTO;
import br.com.alura.med.voll.api.dto.appointment.AppointmentDetailsDTO;
import br.com.alura.med.voll.api.service.appointment.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    @Transactional
    public ResponseEntity<AppointmentDetailsDTO> scheduleAppointment(
            @RequestBody @Valid AppointmentBookingDTO data) {
        var appointment = this.appointmentService.scheduleAppointment(data);
        return ResponseEntity.ok(appointment);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelApponintment(@RequestBody @Valid AppointmentCancellationDTO data) {
        this.appointmentService.cancelAppointment(data);
        return ResponseEntity.noContent().build();
    }

}

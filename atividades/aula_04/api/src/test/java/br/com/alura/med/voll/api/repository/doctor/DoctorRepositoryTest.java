package br.com.alura.med.voll.api.repository.doctor;

import br.com.alura.med.voll.api.dto.address.AddressDTO;
import br.com.alura.med.voll.api.dto.doctor.DoctorDTO;
import br.com.alura.med.voll.api.dto.patient.PatientDTO;
import br.com.alura.med.voll.api.entity.appointment.AppointmentEntity;
import br.com.alura.med.voll.api.entity.doctor.DoctorEntity;
import br.com.alura.med.voll.api.entity.patient.PatientEntity;
import br.com.alura.med.voll.api.enums.doctor.Specialty;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class DoctorRepositoryTest {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private TestEntityManager manager;

    @Test
    @DisplayName("It must return null when only one doctor entity record if it's unavailable on given date.")
    void chooseRandomAvailableDoctorFirstCase() {

        // Sample data / Given - Arrange
        var nextMondayAtTen = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10, 0);
        var doctor = this.registerDoctor("Name", "email@email.com", "123456", Specialty.CARDIOLOGY);
        var patient = this.registerPatient("Name", "email@email.com", "00000000000");
        this.registerAppointment(doctor, patient, nextMondayAtTen);

        // Repository call / When - Act
        var isDoctorNull = this.doctorRepository.chooseRandomAvailableDoctor(Specialty.CARDIOLOGY, nextMondayAtTen);

        // Test / Then - Assert
        assertThat(isDoctorNull).isNull();
    }

    @Test
    @DisplayName("It must return a doctor entity record if it's available on given date.")
    void chooseRandomAvailableDoctorSecondCase() {

        // Sample data / Given - Arrange
        var nextMondayAtTen = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10, 0);
        var doctor = this.registerDoctor("Name", "email@email.com", "123456", Specialty.CARDIOLOGY);

        // Repository call / When - Act
        var isDoctorAvailable = this.doctorRepository.chooseRandomAvailableDoctor(Specialty.CARDIOLOGY, nextMondayAtTen);

        // Test / Then - Assert
        assertThat(isDoctorAvailable).isEqualTo(doctor);
    }

    private void registerAppointment(DoctorEntity doctor, PatientEntity patient, LocalDateTime date) {
        this.manager.persist(new AppointmentEntity(null, doctor, patient, date, null, false));
    }

    private DoctorEntity registerDoctor(String name, String email, String md, Specialty specialty) {
        var doctor = new DoctorEntity(this.getDoctorData(name, email, md, specialty));
        this.manager.persist(doctor);
        return doctor;
    }

    private PatientEntity registerPatient(String name, String email, String ssn) {
        var patient = new PatientEntity(this.getPatientData(name, email, ssn));
        this.manager.persist(patient);
        return patient;
    }

    private DoctorDTO getDoctorData(String name, String email, String md, Specialty specialty) {
        return new DoctorDTO(
                name,
                email,
                "12345678999",
                md,
                specialty,
                this.getAddressData()
        );
    }

    private PatientDTO getPatientData(String name, String email, String cpf) {
        return new PatientDTO(
                name,
                email,
                "12345678999",
                cpf,
                this.getAddressData()
        );
    }

    private AddressDTO getAddressData() {
        return new AddressDTO(
                "Street",
                "Neighborhood",
                "12345678",
                "City",
                "State",
                null,
                null
        );
    }
}
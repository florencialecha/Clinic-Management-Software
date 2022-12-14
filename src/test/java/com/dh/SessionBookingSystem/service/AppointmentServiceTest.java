package com.dh.SessionBookingSystem.service;

import com.dh.SessionBookingSystem.dto.AppointmentDTO;
import com.dh.SessionBookingSystem.entity.Address;
import com.dh.SessionBookingSystem.entity.Dentist;
import com.dh.SessionBookingSystem.entity.Patient;
import com.dh.SessionBookingSystem.exception.BadRequestException;
import com.dh.SessionBookingSystem.exception.ResourceNotFoundException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class AppointmentServiceTest {

    private final PatientService patientService;
    private final DentistService dentistService;
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentServiceTest(PatientService patientService, DentistService dentistService, AppointmentService appointmentService) {
        this.patientService = patientService;
        this.dentistService = dentistService;
        this.appointmentService = appointmentService;
    }

    @Test
    @Order(1)
    public void saveAppointment() throws ResourceNotFoundException, BadRequestException {
        Patient patientToSave = patientService.save(new Patient("Florencia", "Lecha", 5213901, new Address("Eduardo Acevedo", 1261, "Montevideo", "Montevideo"), LocalDate.of(2022, 11, 28), "flecha@gmail.com"));
        Dentist dentistToSave = dentistService.save(new Dentist("Florencia", "Lecha", "12345"));

        AppointmentDTO appointmentToSave = new AppointmentDTO();
        appointmentToSave.setPatientId(patientToSave.getId());
        appointmentToSave.setDentistId(dentistToSave.getId());
        appointmentToSave.setAppointmentDate(LocalDate.of(2022, 12, 12));
        AppointmentDTO appointmentDTOSaved = appointmentService.save(appointmentToSave);

        assertEquals(1L, appointmentDTOSaved.getId());
    }

    @Test
    @Order(2)
    public void findByIdTest() throws ResourceNotFoundException {
        Long searchedId = 1L;
        Optional<AppointmentDTO> appointmentSearched = appointmentService.findById(searchedId);

        assertNotNull(appointmentSearched.get());
    }

    @Test
    @Order(3)
    public void findAllTests () throws ResourceNotFoundException {
        List<AppointmentDTO> apointments = appointmentService.findAll();
        Integer expectedQuantity = 1;

        assertEquals(expectedQuantity, apointments.size());
    }

    @Test
    @Order(4)
    public void updateTest() throws BadRequestException, ResourceNotFoundException {
        Patient patientToUpdate = patientService.save(new Patient("Andy", "Galván", 4900, new Address("Raffo", 802, "Montevideo", "Montevideo"), LocalDate.of(1995, 5, 29), "agalvan@gmail.com"));
        Dentist dentistToUpdate = dentistService.save(new Dentist("Andy", "Galván", "9876"));
        LocalDate newDate = LocalDate.of(2000, 1, 1);

        AppointmentDTO appointmentToUpdate = new AppointmentDTO();
        appointmentToUpdate.setId(1L);
        appointmentToUpdate.setPatientId(patientToUpdate.getId());
        appointmentToUpdate.setDentistId(dentistToUpdate.getId());
        appointmentToUpdate.setAppointmentDate(newDate);
        appointmentService.save(appointmentToUpdate);
        appointmentService.update(appointmentToUpdate);
        Optional<AppointmentDTO> appointmentUpdated = appointmentService.findById(appointmentToUpdate.getId());

        assertEquals(newDate, appointmentUpdated.get().getAppointmentDate());
    }

    @Test
    @Order(5)
    public void deleteByIdTest() throws ResourceNotFoundException {
        Long idToDelete = 1L;
        appointmentService.deleteById(idToDelete);


        ResourceNotFoundException thrown = assertThrows(
                ResourceNotFoundException.class,
                () -> appointmentService.findById(idToDelete).isPresent()
        );

        assertTrue(thrown.getMessage().contains("Don't find any appointment with id: " + idToDelete + ". Try again."));
    }
}
package com.dh.SessionBookingSystem.service;
import com.dh.SessionBookingSystem.entity.Address;
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
public class PatientServiceTest {
    @Autowired
    private PatientService patientService;
    @Test
    @Order(1)
    public void savePatientTest() {
        Patient patientToSave = new Patient("Florencia", "Lecha", 5213901, new Address("Eduardo Acevedo", 1261, "Montevideo", "Montevideo"),LocalDate.of(2022, 11, 28), "flecha@gmail.com");
        Patient patientSaved = patientService.save(patientToSave);

        assertEquals(1L, patientSaved.getId());
    }

    @Test
    @Order(2)
    public void findByIdTest() throws ResourceNotFoundException {
        Long searchedId = 1L;
        Optional<Patient> patientSearched = patientService.findById(searchedId);

        assertNotNull(patientSearched.get());
    }

    @Test
    @Order(3)
    public void findAllTest() throws ResourceNotFoundException {
        List<Patient> patients = patientService.findAll();
        Integer expectedQuantity = 1;

        assertEquals(expectedQuantity, patients.size());
    }

    @Test
    @Order(4)
    public void updateTest() throws BadRequestException, ResourceNotFoundException {
        Patient patientToUpdate = new Patient(1L, "Andy", "GalvÃ¡n", 4900, new Address("Raffo", 802, "Montevideo", "Montevideo"), LocalDate.of(1995, 5, 29), "ag@gmail.com");
        patientService.save(patientToUpdate);
        patientService.update(patientToUpdate);
        Optional<Patient> updatedPatient = patientService.findById(patientToUpdate.getId());

        assertEquals("Andy", updatedPatient.get().getName());
    }

    @Test
    @Order(5)
    public void deleteByIdTest() throws ResourceNotFoundException {
        Long idToDelete = 1L;
        patientService.deleteById(idToDelete);

        Optional<Patient> deletedPatient = patientService.findById(idToDelete);

        assertFalse(deletedPatient.isPresent());
    }
}
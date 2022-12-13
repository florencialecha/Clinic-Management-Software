package com.dh.SessionBookingSystem.service;

import com.dh.SessionBookingSystem.entity.Address;
import com.dh.SessionBookingSystem.entity.Patient;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}

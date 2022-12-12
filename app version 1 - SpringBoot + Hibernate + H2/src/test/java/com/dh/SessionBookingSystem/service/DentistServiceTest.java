package com.dh.SessionBookingSystem.service;

import com.dh.SessionBookingSystem.entity.Dentist;
import com.dh.SessionBookingSystem.exception.BadRequestException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest

public class DentistServiceTest {

    @Autowired
    private DentistService dentistService;

/*    @Test
    @Order(1)
    public void saveDentistTest () throws BadRequestException {
        Dentist dentistToSave = new Dentist("Florencia", "Lecha", "12345");
        Dentist dentistSaved = dentistService.save(dentistToSave);
        assertEquals
    }*/
}

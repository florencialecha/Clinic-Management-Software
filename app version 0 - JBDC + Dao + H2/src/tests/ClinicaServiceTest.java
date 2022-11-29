package tests;

import dao.BD;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.ClinicaService;
import java.util.List;

public class ClinicaServiceTest {

    @Test

    public void caso1() {

        // Arrange:
        ClinicaService clinicaService = new ClinicaService();

        Odontologo odontologo1 = new Odontologo(1, 1000, "Florencia", "Lecha");
        Odontologo odontologo2 = new Odontologo(2, 1001, "Camila", "Agostini");
        Odontologo odontologo3 = new Odontologo(3, 1002, "Matina", "Noguez");
        Odontologo odontologo4 = new Odontologo(4, 1003, "Micaela", "Bentos");
        Odontologo odontologo5 = new Odontologo(5, 1004, "Ana", "Gomez");

        // Act
        BD.crearTabla();
        clinicaService.registrar(odontologo1);
        clinicaService.registrar(odontologo2);
        clinicaService.registrar(odontologo3);
        clinicaService.registrar(odontologo4);
        clinicaService.registrar(odontologo5);

        // Assert

        List<Odontologo> resultadoActual = clinicaService.buscarTodos();
        Integer respuestaEsperada = 5;

        Assertions.assertEquals(respuestaEsperada, resultadoActual.size());

    }
}

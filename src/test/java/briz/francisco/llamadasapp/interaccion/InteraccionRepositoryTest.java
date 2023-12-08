package briz.francisco.llamadasapp.interaccion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class InteraccionRepositoryTest {

    @Autowired
    InteraccionRepository interaccionRepository ;

    @Test
    void insert() {


        interaccionRepository.save(Interaccion.builder()
                .fechaHora(Timestamp.valueOf("2021-12-03 02:56:36"))
                .pregunta("¿Como estas?")
                .respuesta("Bien")
                .llamadaId("0020b1a0-0376-4882-a8ac-b5ec30fab417")
                .build());

        assertEquals(1,interaccionRepository.count());
    }

}
package briz.francisco.llamadasapp.paciente;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PacienteRepositoryTest {

    @Autowired
    PacienteRepository pacienteRepository;


    @Test

    void insert() {

        pacienteRepository.save(Paciente.builder()
                .nombre("Juan")
                .apellido("Perez")
                .dni("sdasdasd")
                .direccion("asdasdasd")
                .telefono("123123123")
                .build());

        assertEquals(1,pacienteRepository.count());

    }

}
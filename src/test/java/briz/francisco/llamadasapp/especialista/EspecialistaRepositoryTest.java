package briz.francisco.llamadasapp.especialista;

import briz.francisco.llamadasapp.llamada.QLlamada;
import briz.francisco.llamadasapp.shared.Turno;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EspecialistaRepositoryTest {

    @Autowired
    EspecialistaRepository especialistaRepository ;

    @Test
    void insert() {

        especialistaRepository.save(Especialista.builder()
                .nombre("Juan")
                .apellido("Perez")
                .email("sdasdasd")
                .direccion("asdasdasd")
                .turno(Turno.TURNO1)
                .categoria(EspecialistaCategoria.MEDICINA)
                .build());

        assertEquals(1,especialistaRepository.count());

    }


}
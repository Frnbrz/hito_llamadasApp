package briz.francisco.llamadasapp.especialista;


import briz.francisco.llamadasapp.llamada.QLlamada;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository

public class EspecialistaRepository {
    private final JPAQueryFactory sql;

    public EspecialistaRepository(JPAQueryFactory sql) {
        this.sql = sql;
    }

    private final QEspecialista especialista = QEspecialista.especialista;
    private  final QLlamada llamada = QLlamada.llamada;


    public Especialista getEspecialistaById(String id) {
        return sql.selectFrom(especialista)
                .where(especialista.id.eq(id))
                .fetchOne();
    }

    public Especialista getEspecialistaByEmail(String email) {
        return sql.selectFrom(especialista)
                .where(especialista.email.eq(email))
                .fetchOne();
    }

    public List<Especialista> getByNameAndSurname(String nombre, String apellido,Boolean esBroma) {
        return sql.selectFrom(especialista)
                .where(especialista.nombre.eq(nombre)
                        .and(especialista.apellido.eq(apellido))

                .and(llamada.esBroma.eq(false))
                )
                .join(llamada)
                .on(especialista.id.eq(llamada.especialistaId))
                .fetch();
    }

    public long count(){
        return (int) sql.selectFrom(especialista).fetchCount();
    }
    @Transactional
    public void save(Especialista especialistav){

       sql.insert(especialista)
                .columns(
                        especialista.nombre,
                        especialista.apellido,
                        especialista.email,
                        especialista.direccion,
                        especialista.turno,
                        especialista.categoria)
                .values(
                especialistav.getNombre(),
                especialistav.getApellido(),
                especialistav.getEmail(),
                especialistav.getDireccion(),
                especialistav.getTurno().name(),
                especialistav.getCategoria().name()
        ).execute();

    }

    public List<Especialista> findAll(){
        return sql.selectFrom(especialista).fetch();
    }

}

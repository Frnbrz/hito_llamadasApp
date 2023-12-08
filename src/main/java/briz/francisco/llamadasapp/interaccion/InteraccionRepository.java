package briz.francisco.llamadasapp.interaccion;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

 @Repository
public class InteraccionRepository {

    private final JPAQueryFactory sql;

    public InteraccionRepository(JPAQueryFactory sql) {
        this.sql = sql;
    }

    private final QInteraccion interaccion = QInteraccion.interaccion;

    public Interaccion getInteraccionById(String id) {
        return sql.selectFrom(interaccion)
                .where(interaccion.id.eq(id))
                .fetchOne();
    }

    public long count(){
        return (int) sql.selectFrom(interaccion).fetchCount();
    }

    @Transactional
    public void save(Interaccion inter){

        sql.insert(interaccion)
                .columns(
                        interaccion.fechaHora,
                        interaccion.pregunta,
                        interaccion.respuesta,
                        interaccion.llamadaId)
                .values(
                        inter.getFechaHora(),
                        inter.getPregunta(),
                        inter.getRespuesta(),
                        inter.getLlamadaId()
        )
                .execute();
        System.out.println("Se inserto la interaccion");
    }

    public List<Interaccion> findAll(){
        return sql.selectFrom(interaccion).fetch();
    }



}

package briz.francisco.llamadasapp.llamada;

import com.querydsl.jpa.JPQLQueryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class LlamadaRepository {

    private final JPQLQueryFactory sql;
    private final QLlamada llamada = QLlamada.llamada;

    public LlamadaRepository(JPQLQueryFactory sql) {
        this.sql = sql;
    }


    public Llamada getLlamadaById(String id) {
        return sql.selectFrom(llamada)
                .where(llamada.id.eq(id))
                .fetchOne();
    }


    public List<Llamada> getLlamadasByEspercialistaIdAndComentarioNull(String id) {
        return sql.selectFrom(llamada)
                .where(llamada.especialistaId.eq(id))
                .where(llamada.comentario.isNull())
                .fetch();
    }

    public long count() {
        return (int) sql.selectFrom(llamada).fetchCount();
    }


    @Transactional
    public void save(Llamada llam) {
        sql.insert(llamada)
                .columns(

                        llamada.esBroma,
                        llamada.fechaHora,
                        llamada.comentario,
                        llamada.operadorId,
                        llamada.especialistaId,
                        llamada.pacienteId
                )
                .values(
                        llam.getEsBroma(),
                        llam.getFechaHora(),
                        llam.getComentario(),
                        llam.getOperadorId(),
                        llam.getEspecialistaId(),
                        llam.getPacienteId()
                )
                .execute();
    }

    @Transactional
    public void udpdate(Llamada llam) {
        sql.update(llamada)
                .set(llamada.comentario, llam.getComentario())
                .where(llamada.id.eq(llam.getId()))
                .execute();
    }

    public List<Llamada> findAll() {
        return sql.selectFrom(llamada).fetch();
    }
}

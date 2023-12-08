package briz.francisco.llamadasapp.operador;

import com.querydsl.jpa.JPQLQueryFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Repository
public class OperadorRepository {

    private final JPQLQueryFactory sql;

    public OperadorRepository(JPQLQueryFactory sql) {
        this.sql = sql;
    }

    private final QOperador operador = QOperador.operador;

    public Operador getOperadorById(String id) {
        return sql.selectFrom(operador)
                .where(operador.id.eq(id))
                .fetchOne();
    }

    public Operador getOperadorByEmail(String email) {
        return sql.selectFrom(operador)
                .where(operador.email.eq(email))
                .fetchOne();
    }

    public long count(){
        return (int) sql.selectFrom(operador).fetchCount();
    }

    @Transactional
    public void save(Operador oper){
        sql.insert(operador)
                .columns(
                        operador.nombre,
                        operador.apellido,
                        operador.email,
                        operador.direccion,
                        operador.turno)
                .values(
                        oper.getNombre(),
                        oper.getApellido(),
                        oper.getEmail(),
                        oper.getDireccion(),
                        oper.getTurno().name())
                .execute();
    }

    public List<Operador> findAll(){
        return sql.selectFrom(operador).fetch();
    }
}

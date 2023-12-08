package briz.francisco.llamadasapp.paciente;

import com.querydsl.jpa.JPQLQueryFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Repository
public class PacienteRepository {

    private final JPQLQueryFactory sql;

    public PacienteRepository(JPQLQueryFactory sql) {
        this.sql = sql;
    }

    private final QPaciente paciente = QPaciente.paciente;

    public Paciente getPacienteById(String id) {
        return sql.selectFrom(paciente)
                .where(paciente.id.eq(id))
                .fetchOne();
    }

    public long count(){
        return (int) sql.selectFrom(paciente).fetchCount();
    }

    @Transactional

    public void save(Paciente pac){
        sql.insert(paciente)
                .columns(
                        paciente.nombre,
                        paciente.apellido,
                        paciente.dni,
                        paciente.direccion,
                        paciente.telefono)
                .values(
                        pac.getNombre(),
                        pac.getApellido(),
                        pac.getDni(),
                        pac.getDireccion(),
                        pac.getTelefono())
                .execute();
    }

    public List<Paciente > findAll(){
        return sql.selectFrom(paciente).fetch();
    }
}

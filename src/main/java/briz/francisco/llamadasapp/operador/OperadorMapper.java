package briz.francisco.llamadasapp.operador;

import briz.francisco.llamadasapp.llamada.Llamada;
import briz.francisco.llamadasapp.llamada.LlamadaMapper;
import briz.francisco.llamadasapp.shared.Turno;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperadorMapper {

    LlamadaMapper llamadaMapper;

    public OperadorMapper(LlamadaMapper llamadaMapper) {
        this.llamadaMapper = llamadaMapper;
    }

    OperadorDTO operadorToOperadorDto(Operador operador) {

        if (operador == null) {
            return null;
        } else {
            OperadorDTO.OperadorDTOBuilder operadorDTO = OperadorDTO.builder();
            operadorDTO.turno(this.operadorTurnoTurnoDescripcion(operador));
            operadorDTO.id(operador.getId());
            operadorDTO.nombre(operador.getNombre());
            operadorDTO.apellido(operador.getApellido());
            operadorDTO.email(operador.getEmail());
            operadorDTO.direccion(operador.getDireccion());
            List<Llamada> list = operador.getLlamadas();
            if (list != null) {
                operadorDTO.llamadas(list.stream()
                        .map(llamada -> llamadaMapper.llamadaToLlamadaDto(llamada)).toList());
            }

            return operadorDTO.build();


        }
    }

    Operador operadorDtoToOperador(OperadorDTO operadorDto) {
        return null;
    }

    private String operadorTurnoTurnoDescripcion(Operador operador) {
        if (operador == null) {
            return null;
        } else {
            Turno turno = operador.getTurno();
            if (turno == null) {
                return null;
            } else {
                String turnoDescripcion = turno.getTurnoDescripcion();
                return turnoDescripcion == null ? null : turnoDescripcion;
            }
        }
    }

}

package briz.francisco.llamadasapp.paciente;


import briz.francisco.llamadasapp.llamada.Llamada;
import briz.francisco.llamadasapp.llamada.LlamadaMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PacienteMapper {

    LlamadaMapper llamadaMapper;

    public PacienteMapper(LlamadaMapper llamadaMapper) {
        this.llamadaMapper = llamadaMapper;
    }

    PacienteDTO pacienteToPacienteDto(Paciente paciente){

        if(paciente==null){
            return null;
        }else{

            PacienteDTO.PacienteDTOBuilder pacienteDTO = PacienteDTO.builder();
            pacienteDTO.id(paciente.getId());
            pacienteDTO.nombre(paciente.getNombre());
            pacienteDTO.dni(paciente.getDni());
            pacienteDTO.telefono(paciente.getTelefono());
            pacienteDTO.direccion(paciente.getDireccion());
            List<Llamada> list = paciente.getLlamadas();
            if(list!=null){
                pacienteDTO.llamadas(list.stream()
                        .map(llamada -> llamadaMapper.llamadaToLlamadaDto(llamada)
                        ).toList());
            }
            return pacienteDTO.build();
        }


    }
    Paciente pacienteDtoToPaciente(PacienteDTO pacienteDTO){
        return null;
    }
}

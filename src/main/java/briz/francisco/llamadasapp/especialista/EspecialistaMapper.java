package briz.francisco.llamadasapp.especialista;


import briz.francisco.llamadasapp.llamada.Llamada;
import briz.francisco.llamadasapp.llamada.LlamadaDTO;
import briz.francisco.llamadasapp.llamada.LlamadaMapper;
import briz.francisco.llamadasapp.shared.Turno;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EspecialistaMapper {

    LlamadaMapper llamadaMapper;

    public EspecialistaMapper(LlamadaMapper llamadaMapper) {
        this.llamadaMapper = llamadaMapper;
    }

    public EspecialistaDTO especialistaToEspecialistaDto(Especialista especialista) {
        if (especialista == null) {
            return null;
        } else {
            EspecialistaDTO.EspecialistaDTOBuilder especialistaDTO = EspecialistaDTO.builder();
            especialistaDTO.turno(this.especialistaTurnoTurnoDescripcion(especialista));
            especialistaDTO.id(especialista.getId());
            especialistaDTO.nombre(especialista.getNombre());
            especialistaDTO.apellido(especialista.getApellido());
            especialistaDTO.email(especialista.getEmail());
            especialistaDTO.direccion(especialista.getDireccion());
            especialistaDTO.categoria(especialista.getCategoria());
            List<Llamada> list = especialista.getLlamadas();
            if (list != null) {
                especialistaDTO.llamadas(list.stream()
                        .map(llamada -> llamadaMapper.llamadaToLlamadaDto(llamada)).toList());
            }

            return especialistaDTO.build();
        }
    }

    public Especialista especialistaDtoToEspecialista(EspecialistaDTO dto) {
        if (dto == null) {
            return null;
        } else {
            Especialista.EspecialistaBuilder especialista = Especialista.builder();
            especialista.id(dto.getId());
            especialista.nombre(dto.getNombre());
            especialista.apellido(dto.getApellido());
            especialista.email(dto.getEmail());
            especialista.direccion(dto.getDireccion());
            especialista.categoria(dto.getCategoria());
            List<LlamadaDTO> list = dto.getLlamadas();
            if (list != null) {
                especialista.llamadas(new ArrayList(list));
            }

            especialista.turno(Turno.getTurno(dto.getTurno()));
            return especialista.build();
        }
    }

    private String especialistaTurnoTurnoDescripcion(Especialista especialista) {
        if (especialista == null) {
            return null;
        } else {
            Turno turno = especialista.getTurno();
            if (turno == null) {
                return null;
            } else {
                String turnoDescripcion = turno.getTurnoDescripcion();
                return turnoDescripcion == null ? null : turnoDescripcion;
            }
        }
    }
}
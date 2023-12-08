package briz.francisco.llamadasapp.llamada;

import briz.francisco.llamadasapp.interaccion.Interaccion;
import briz.francisco.llamadasapp.interaccion.InteraccionDTO;
import briz.francisco.llamadasapp.interaccion.InteraccionMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LlamadaMapper {

   private final InteraccionMapper interaccionMapper;

    public LlamadaMapper(InteraccionMapper interaccionMapper) {
        this.interaccionMapper = interaccionMapper;
    }

    public LlamadaDTO llamadaToLlamadaDto(Llamada llamada) {

        if (llamada == null) {
            return null;
        } else {
            LlamadaDTO.LlamadaDTOBuilder llamadaDTO = LlamadaDTO.builder();
            llamadaDTO.id(llamada.getId());
            llamadaDTO.esBroma(llamada.getEsBroma());
            llamadaDTO.fechaHora(llamada.getFechaHora());
            llamadaDTO.comentario(llamada.getComentario());
            llamadaDTO.operadorId(llamada.getOperadorId());
            llamadaDTO.pacienteId(llamada.getPacienteId());
            llamadaDTO.especialistaId(llamada.getEspecialistaId());
            List<Interaccion> list = llamada.getInteracciones();
            if (list != null) {
                llamadaDTO.interacciones(list.stream()
                        .map(interaccionMapper::interaccionToInteraccionDto
                        ).toList());
            }

            return llamadaDTO.build();
        }

    }

    public Llamada llamadaDtoToLlamada(LlamadaDTO llamadaDto){
        if(llamadaDto==null){
            return null;}
        else{
            Llamada.LlamadaBuilder llamada = Llamada.builder();
            llamada.id(llamadaDto.getId());
            llamada.esBroma(llamadaDto.getEsBroma());
            llamada.fechaHora(llamadaDto.getFechaHora());
            llamada.comentario(llamadaDto.getComentario());
            llamada.operadorId(llamadaDto.getOperadorId());
            llamada.pacienteId(llamadaDto.getPacienteId());
            llamada.especialistaId(llamadaDto.getEspecialistaId());
            return llamada.build();
        }


    }


}

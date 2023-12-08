package briz.francisco.llamadasapp.interaccion;


import org.springframework.stereotype.Component;

@Component
public class InteraccionMapper {


    public Interaccion interaccionDtoToInteraccion(InteraccionDTO interaccionDto){
        if(interaccionDto==null){
            return null;}
        else{
            Interaccion.InteraccionBuilder interaccion = Interaccion.builder();
            interaccion.id(interaccionDto.getId());
            interaccion.fechaHora(interaccionDto.getFechaHora());
            interaccion.pregunta(interaccionDto.getPregunta());
            interaccion.respuesta(interaccionDto.getRespuesta());
            interaccion.llamadaId(interaccionDto.getLlamadaId());
            return interaccion.build();
        }
    }

    public InteraccionDTO interaccionToInteraccionDto(Interaccion interaccion){
        if(interaccion==null){
            return null;
        }else{
            InteraccionDTO.InteraccionDTOBuilder interaccionDTO = InteraccionDTO.builder();
            interaccionDTO.id(interaccion.getId());
            interaccionDTO.fechaHora(interaccion.getFechaHora());
            interaccionDTO.pregunta(interaccion.getPregunta());
            interaccionDTO.respuesta(interaccion.getRespuesta());
            interaccionDTO.llamadaId(interaccion.getLlamadaId());
            return interaccionDTO.build();
        }

    }
}

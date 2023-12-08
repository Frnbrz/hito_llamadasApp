package briz.francisco.llamadasapp.interaccion;


import briz.francisco.llamadasapp.llamada.LlamadaDTO;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Builder
public class InteraccionDTO {


    private String id;

    private Timestamp fechaHora;

    private String pregunta;

    private String respuesta;

    private String llamadaId;

    private LlamadaDTO llamada;

}

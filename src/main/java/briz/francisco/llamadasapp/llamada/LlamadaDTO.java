package briz.francisco.llamadasapp.llamada;


import briz.francisco.llamadasapp.especialista.EspecialistaDTO;
import briz.francisco.llamadasapp.interaccion.InteraccionDTO;
import briz.francisco.llamadasapp.operador.OperadorDTO;
import briz.francisco.llamadasapp.paciente.PacienteDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class LlamadaDTO {

    private String id;
    private Boolean esBroma;
    private Timestamp fechaHora;
    private String comentario;

    private String operadorId;
    private String especialistaId;
    private String pacienteId;
    private EspecialistaDTO especialista;
    private OperadorDTO operador;
    private PacienteDTO paciente;
    private List<InteraccionDTO> interacciones;
}

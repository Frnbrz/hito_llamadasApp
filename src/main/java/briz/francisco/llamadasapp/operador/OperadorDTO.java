package briz.francisco.llamadasapp.operador;

import briz.francisco.llamadasapp.llamada.LlamadaDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class OperadorDTO {

    private String id;

    private String nombre;
    private String apellido;
    private String email;
    private String direccion;
    private String turno;
    private List<LlamadaDTO> llamadas;

}

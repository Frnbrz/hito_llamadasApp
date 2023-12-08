package briz.francisco.llamadasapp.especialista;

import briz.francisco.llamadasapp.llamada.Llamada;
import briz.francisco.llamadasapp.llamada.LlamadaDTO;
import briz.francisco.llamadasapp.shared.Turno;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
 @Builder
public class EspecialistaDTO {

    private String id;

    private String nombre;
    private String apellido;
    private String email;
    private String direccion;
    private String turno;
    private EspecialistaCategoria categoria;
    private List<LlamadaDTO> llamadas;

}

package briz.francisco.llamadasapp.paciente;


import briz.francisco.llamadasapp.llamada.Llamada;
import briz.francisco.llamadasapp.llamada.LlamadaDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class PacienteDTO {

    private String id;

    private String dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private List<LlamadaDTO> llamadas;
}

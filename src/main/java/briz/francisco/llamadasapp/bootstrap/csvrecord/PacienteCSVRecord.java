package briz.francisco.llamadasapp.bootstrap.csvrecord;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class PacienteCSVRecord {

    @CsvBindByName
    private String dni;

    @CsvBindByName
    private String nombre;

    @CsvBindByName
    private String apellido;

    @CsvBindByName
    private String direccion;

    @CsvBindByName
    private String telefono;
}

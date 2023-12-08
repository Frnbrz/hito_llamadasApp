package briz.francisco.llamadasapp.bootstrap.csvrecord;


import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class EspecialistaCSVRecord {
    @CsvBindByName
    private String nombre;

    @CsvBindByName
    private String apellido;

    @CsvBindByName
    private String email;

    @CsvBindByName
    private String direccion;

}

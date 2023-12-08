package briz.francisco.llamadasapp.bootstrap.csvrecord;


import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class LlamadaCSVRecord {
    @CsvBindByName
    private Timestamp fechaHora;

    @CsvBindByName
    private Boolean esBroma;

    @CsvBindByName
    private UUID operadorId;

    @CsvBindByName
    private UUID especialistaId;

    @CsvBindByName
    private UUID pacienteId;



}

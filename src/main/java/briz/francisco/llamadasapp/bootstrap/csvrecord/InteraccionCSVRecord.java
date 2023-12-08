package briz.francisco.llamadasapp.bootstrap.csvrecord;


import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class InteraccionCSVRecord {
    @CsvBindByName
    private String frase;


}

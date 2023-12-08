package briz.francisco.llamadasapp.bootstrap;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class CSVParser{

    public <T> List<T> parseCSV(String csvFile, Class<T> clazz) {
        try {
            return new CsvToBeanBuilder<T>(new FileReader(csvFile))
                    .withType(clazz)
                    .build().parse();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

package briz.francisco.llamadasapp.bootstrap;

import briz.francisco.llamadasapp.bootstrap.csvrecord.EspecialistaCSVRecord;
import briz.francisco.llamadasapp.bootstrap.csvrecord.InteraccionCSVRecord;
import briz.francisco.llamadasapp.bootstrap.csvrecord.OperadorCSVRecord;
import briz.francisco.llamadasapp.bootstrap.csvrecord.PacienteCSVRecord;
import briz.francisco.llamadasapp.especialista.Especialista;
import briz.francisco.llamadasapp.especialista.EspecialistaCategoria;
import briz.francisco.llamadasapp.especialista.EspecialistaRepository;
import briz.francisco.llamadasapp.interaccion.Interaccion;
import briz.francisco.llamadasapp.interaccion.InteraccionRepository;
import briz.francisco.llamadasapp.llamada.Llamada;
import briz.francisco.llamadasapp.llamada.LlamadaRepository;
import briz.francisco.llamadasapp.operador.Operador;
import briz.francisco.llamadasapp.operador.OperadorRepository;
import briz.francisco.llamadasapp.paciente.Paciente;
import briz.francisco.llamadasapp.paciente.PacienteRepository;
import briz.francisco.llamadasapp.shared.Turno;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private final OperadorRepository operadorlistaRepository;
    private final LlamadaRepository llamadalistaRepository;
    private final EspecialistaRepository especialistaRepository;
    private final PacienteRepository pacienteRepository;
    private final InteraccionRepository interaccionRepository;
    private final CSVParser csvParser;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        loadOperadorData();
        loadEspecialistaData();
        loadPacienteData();
        loadLLamadaData();
        loadInteraccionData();
    }



    private void loadPacienteData() throws FileNotFoundException{
        if(pacienteRepository.count()<10){
            File file = ResourceUtils.getFile("classpath:csvdata/paciente.csv");
            List<PacienteCSVRecord> records = csvParser.parseCSV(file.getAbsolutePath(), PacienteCSVRecord.class);

            records.forEach( pacienteCSVRecord -> {
                        Paciente paciente= Paciente.builder()
                                .dni(pacienteCSVRecord.getDni())
                                .nombre(pacienteCSVRecord.getNombre())
                                .apellido(pacienteCSVRecord.getApellido())
                                .direccion(pacienteCSVRecord.getDireccion())
                                .telefono(pacienteCSVRecord.getTelefono())
                                .build();
                        pacienteRepository.save(paciente);
                    }
            );

        }
    }

    private void loadEspecialistaData() throws FileNotFoundException {

        if(especialistaRepository.count()<10){
            File file = ResourceUtils.getFile("classpath:csvdata/especialista.csv");

            List<EspecialistaCSVRecord> records = csvParser.parseCSV(file.getAbsolutePath(), EspecialistaCSVRecord.class);
            records.forEach(especialistaCSVRecord -> {
                Random random = new Random();
                Especialista especialista = Especialista.builder()
                        .nombre(especialistaCSVRecord.getNombre())
                        .apellido(especialistaCSVRecord.getApellido())
                        .email(especialistaCSVRecord.getEmail())
                        .direccion(especialistaCSVRecord.getDireccion())
                        .turno(Turno.values()[random.nextInt(Turno.values().length)])
                        .categoria(EspecialistaCategoria.values()[random.nextInt(EspecialistaCategoria.values().length)])
                        .build();
                especialistaRepository.save(especialista);
            });
        }
    }

    private void loadOperadorData() throws FileNotFoundException {
        if(operadorlistaRepository.count()<10){
            File file = ResourceUtils.getFile("classpath:csvdata/operador.csv");
            List<OperadorCSVRecord> records = csvParser.parseCSV(file.getAbsolutePath(), OperadorCSVRecord.class);
            Random random = new Random();
            records.forEach( operadorCSVRecord -> {
                        Operador operador = Operador.builder()
                                .nombre(operadorCSVRecord.getNombre())
                                .apellido(operadorCSVRecord.getApellido())
                                .email(operadorCSVRecord.getEmail())
                                .direccion(operadorCSVRecord.getDireccion())
                                .turno(Turno.values()[random.nextInt(Turno.values().length)])
                                .build();
                        operadorlistaRepository.save(operador);
                    }
            );

        }
    }

    private void loadLLamadaData() {
        if (llamadalistaRepository.count() < 10) {

            List<Operador> operadores = operadorlistaRepository.findAll();
            List<Especialista> especialistas = especialistaRepository.findAll();
            List<Paciente> pacientes = pacienteRepository.findAll();
            Random random = new Random();
            for (int i = 0; i < 500; i++) {
                Llamada llamada = Llamada.builder()
                        .fechaHora(new java.sql.Timestamp(1588326000000L + (long) (Math.random() * (1691364000000L - 1588326000000L))))
                        .esBroma(i % 100 == 0 ? Boolean.TRUE : Boolean.FALSE)
                        .operadorId(operadores.get(random.nextInt(operadores.size())).getId())
                        .especialistaId(i % 10 == 0 ? null : especialistas.get(random.nextInt(especialistas.size())).getId())
                        .pacienteId(pacientes.get(random.nextInt(pacientes.size())).getId())
                        .build();
                llamadalistaRepository.save(llamada);
            }
        }
    }
    private void loadInteraccionData() throws FileNotFoundException{

        if (interaccionRepository.count() < 10) {
            File file = ResourceUtils.getFile("classpath:csvdata/interaccion.csv");
            List<InteraccionCSVRecord> records = csvParser.parseCSV(file.getAbsolutePath(), InteraccionCSVRecord.class);
            List<Llamada> llamadas = llamadalistaRepository.findAll();

            llamadas
//                    .stream()
//                    .limit(100)
                    .forEach(llamada -> {
//                        try {
//                            Thread.sleep(10);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
                        Random random = new Random();
                for (int i = 0; i < random.nextInt(20); i++) {
                    Interaccion interaccion = Interaccion.builder()
                            .fechaHora(new java.sql.Timestamp(llamada.getFechaHora().getTime() + (long) (Math.random() * (1800000L))))
                            .pregunta(records.get(random.nextInt(records.size())).getFrase())
                            .respuesta(records.get(random.nextInt(records.size())).getFrase())
                            .llamadaId(llamada.getId())
                            .build();
                    interaccionRepository.save(interaccion);
                }
            });
        }
    }

}
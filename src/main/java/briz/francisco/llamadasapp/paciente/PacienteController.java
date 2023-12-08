package briz.francisco.llamadasapp.paciente;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
@RestController
public class PacienteController {

    public static final String PACIENTE_PATH = "/api/v1/pacientes";
    public static final String PACIENTE_PATH_ID = PACIENTE_PATH + "/{pacienteId}";

    private final PacienteService pacienteService;


    @DeleteMapping(PACIENTE_PATH_ID)
    public ResponseEntity deleteById(@PathVariable("pacienteId") UUID pacienteId) {

        pacienteService.deleteById(pacienteId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(PACIENTE_PATH_ID)
    public ResponseEntity updateById(@PathVariable("pacienteid") UUID pacienteid, @Validated @RequestBody PacienteDTO dto) {

        pacienteService.updatePaciente(dto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(PACIENTE_PATH)
    public ResponseEntity<PacienteDTO> handlePost(@Validated @RequestBody PacienteDTO dto) {

        PacienteDTO operador = pacienteService.createPaciente(dto);


        return new ResponseEntity<>(operador, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = PACIENTE_PATH)
    public List<PacienteDTO> getPacientes() {
        return pacienteService.getPacientes();
    }


    @GetMapping(value = PACIENTE_PATH_ID)
    public ResponseEntity<PacienteDTO> getOperador(@PathVariable("pacienteId") String pacienteId) {

        log.debug("Get Operador by Id - in controller");

        PacienteDTO pacienteDTO = pacienteService.getPaciente(pacienteId);

        if (pacienteDTO == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(pacienteDTO);
        }
    }
}

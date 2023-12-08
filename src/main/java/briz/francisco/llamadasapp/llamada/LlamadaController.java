package briz.francisco.llamadasapp.llamada;


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
public class LlamadaController {

    public static final String LLAMADA_PATH = "/api/v1/llamadas";
    public static final String LLAMADA_PATH_ID = LLAMADA_PATH + "/{llamadaId}";
    public static final String LLAMADA_PATH_ESPECIALISTA = LLAMADA_PATH + "/especialista/{especialistaId}";

    private final LlamadaService llamadaService;


    @DeleteMapping(LLAMADA_PATH_ID)
    public ResponseEntity deleteById(@PathVariable("llamadaId") UUID llamadaId) {

        llamadaService.deleteById(llamadaId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @CrossOrigin(origins = "*")
    @PutMapping(LLAMADA_PATH_ID)
    public ResponseEntity updateById(@PathVariable("llamadaId") String llamadaId, @Validated @RequestBody LlamadaDTO dto) {
        dto.setId(llamadaId);
        llamadaService.updateLlamada(dto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(LLAMADA_PATH)
    public ResponseEntity<LlamadaDTO> handlePost(@Validated @RequestBody LlamadaDTO dto) {

        System.out.println(dto);

        LlamadaDTO interaccion = llamadaService.createLlamada(dto);


        return new ResponseEntity<>(interaccion, HttpStatus.CREATED);
    }

    @GetMapping(value = LLAMADA_PATH)
    public List<LlamadaDTO> getLlamadas() {
        return llamadaService.getLlamadas();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(LLAMADA_PATH_ESPECIALISTA)
    public List<LlamadaDTO> getLlamadasByEspecialistaId(@PathVariable("especialistaId") String especialistaId) {
        return llamadaService.getLlamadasByEspecialistaId(especialistaId);
    }


    @GetMapping(value = LLAMADA_PATH_ID)
    public ResponseEntity<LlamadaDTO> getLlamadasById(@PathVariable("llamadaId") String llamadaId) {

        log.debug("Get Especialista by Id - in controller");

        LlamadaDTO llamadaDTO = llamadaService.getLlamada(llamadaId);

        if (llamadaDTO == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(llamadaDTO);
        }
    }
}

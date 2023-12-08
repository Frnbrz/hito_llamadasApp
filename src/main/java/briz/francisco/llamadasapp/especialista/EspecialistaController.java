package briz.francisco.llamadasapp.especialista;

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
public class EspecialistaController {

    public static final String ESPECIALISTA_PATH = "/api/v1/especialistas";
    public static final String ESPECIALISTA_PATH_ID = ESPECIALISTA_PATH + "/{especialistaId}";

    private final EspecialistaService especialistaService;


    @DeleteMapping(ESPECIALISTA_PATH_ID)
    public ResponseEntity deleteById(@PathVariable("especialistaId") UUID especialistaId) {

        especialistaService.deleteById(especialistaId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(ESPECIALISTA_PATH_ID)
    public ResponseEntity updateById(@PathVariable("especialistaId") String especialistaId, @Validated @RequestBody EspecialistaDTO dto) {
        dto.setId(especialistaId);
        especialistaService.updateEspecialista(dto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(ESPECIALISTA_PATH)
    public ResponseEntity<EspecialistaDTO> handlePost(@Validated @RequestBody EspecialistaDTO dto) {

        EspecialistaDTO especialista = especialistaService.createEspecialista(dto);


        return new ResponseEntity<>(especialista, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = ESPECIALISTA_PATH)
    public List<EspecialistaDTO> getEspecialistas() {
        return especialistaService.getEspecialistas();
    }


    @GetMapping(value = ESPECIALISTA_PATH_ID)
    public ResponseEntity<EspecialistaDTO> getEspecialistaById(@PathVariable("especialistaId") String especialistaId) {

        log.debug("Get Especialista by Id - in controller");


        EspecialistaDTO especialistaDTO = especialistaService.getEspecialista(especialistaId);

        if (especialistaDTO == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(especialistaDTO);
        }
    }
}

package briz.francisco.llamadasapp.interaccion;

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
public class InteraccionController {

    public static final String INTERACCION_PATH = "/api/v1/interacciones";
    public static final String INTERACCION_PATH_ID = INTERACCION_PATH + "/{interaccionId}";

    private final InteraccionService interaccionService;


    @DeleteMapping(INTERACCION_PATH_ID)
    public ResponseEntity deleteById(@PathVariable("interaccionId") UUID interaccionId) {

        interaccionService.deleteById(interaccionId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(INTERACCION_PATH_ID)
    public ResponseEntity updateById(@PathVariable("interaccionId") UUID interaccionId, @Validated @RequestBody InteraccionDTO dto) {

        interaccionService.updateInteraccion(dto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(INTERACCION_PATH)
    public ResponseEntity<InteraccionDTO> handlePost(@Validated @RequestBody InteraccionDTO dto) {

        InteraccionDTO interaccion = interaccionService.createInteraccion(dto);


        return new ResponseEntity<>(interaccion, HttpStatus.CREATED);
    }

    @GetMapping(value = INTERACCION_PATH)
    public List<InteraccionDTO> getInteracciones() {
        return interaccionService.getInteracciones();
    }


    @GetMapping(value = INTERACCION_PATH_ID)
    public InteraccionDTO getInteraccionById(@PathVariable("interaccionId") String interaccionId) {

        log.debug("Get Especialista by Id - in controller");

        return interaccionService.getInteraccion(interaccionId);
    }
}

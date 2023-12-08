package briz.francisco.llamadasapp.operador;

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
public class OperatorController {

    public static final String OPERADOR_PATH = "/api/v1/operadores";
    public static final String OPERADOR_PATH_ID = OPERADOR_PATH + "/{operadorId}";

    private final OperadorService operadorService;


    @DeleteMapping(OPERADOR_PATH_ID)
    public ResponseEntity deleteById(@PathVariable("operadorId") UUID operadorId) {

        operadorService.deleteById(operadorId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(OPERADOR_PATH_ID)
    public ResponseEntity updateById(@PathVariable("operadorId") UUID operadorId, @Validated @RequestBody OperadorDTO dto) {

        operadorService.updateOperador(dto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(OPERADOR_PATH)
    public ResponseEntity<OperadorDTO> handlePost(@Validated @RequestBody OperadorDTO dto) {

        OperadorDTO operador = operadorService.createOperador(dto);


        return new ResponseEntity<>(operador, HttpStatus.CREATED);
    }

    @GetMapping(value = OPERADOR_PATH)
    public List<OperadorDTO> getOperadores() {
        return operadorService.getOperadores();
    }


    @GetMapping(value = OPERADOR_PATH_ID)
    public OperadorDTO getOperador(@PathVariable("operadorId") String operadorId) {

        log.debug("Get Operador by Id - in controller");

        return operadorService.getOperador(operadorId);
    }
}

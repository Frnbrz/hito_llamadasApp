package briz.francisco.llamadasapp.operador;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OperadorService {

    private final OperadorRepository operadorRepository;
    private final OperadorMapper operadorMapper;

    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_SIZE = 25;

    public OperadorDTO createOperador(OperadorDTO operadorDto) {
//        return operadorMapper.operadorToOperadorDto(operadorRepository.save(operadorMapper.operadorDtoToOperador(operadorDto)));
        return null;

    }

    public OperadorDTO getOperador(String id) {

//        return operadorMapper.operadorToOperadorDto(operadorRepository.findById(id).orElseThrow(() -> new RuntimeException("Especialista no encontrado")));

        return operadorMapper.operadorToOperadorDto(operadorRepository.getOperadorById(id));

    }

    public OperadorDTO updateOperador(OperadorDTO operadorDto) {
//        return operadorMapper.operadorToOperadorDto(operadorRepository.save(operadorMapper.operadorDtoToOperador(operadorDto)));
        return null;

    }

    public List<OperadorDTO> getOperadores() {
        return operadorRepository.findAll().stream().map(operadorMapper::operadorToOperadorDto).toList();
    }

    public void deleteById(UUID id) {
//        operadorRepository.deleteById(id);

    }
}

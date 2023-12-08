package briz.francisco.llamadasapp.interaccion;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InteraccionService {

    private final InteraccionRepository interaccionRepository;
    private final InteraccionMapper interaccionMapper;

    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_SIZE = 25;

    public InteraccionDTO createInteraccion(InteraccionDTO interaccionDTO) {
        Interaccion interaccion = interaccionMapper.interaccionDtoToInteraccion(interaccionDTO);
        interaccion.setId(UUID.randomUUID().toString());
        interaccion.setFechaHora(new Timestamp(System.currentTimeMillis()));
        interaccionRepository.save(interaccion);
        return interaccionMapper.interaccionToInteraccionDto(interaccion);
    }

    public InteraccionDTO getInteraccion(String id) {
        return interaccionMapper.interaccionToInteraccionDto(interaccionRepository.getInteraccionById(id));
    }

    public InteraccionDTO updateInteraccion(InteraccionDTO interaccionDTO) {
//        return interaccionMapper.interaccionToInteraccionDto(interaccionRepository.save(interaccionMapper.interaccionDtoToInteraccion(interaccionDTO)));
        return null;
    }

    public List<InteraccionDTO> getInteracciones() {
        return interaccionRepository.findAll().stream().map(interaccionMapper::interaccionToInteraccionDto).toList();
    }

    public void deleteById(UUID id) {

//        interaccionRepository.deleteById(id);
    }
}

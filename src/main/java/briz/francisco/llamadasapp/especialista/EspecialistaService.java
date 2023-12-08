package briz.francisco.llamadasapp.especialista;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EspecialistaService {

    private final EspecialistaRepository especialistaRepository;
    private final EspecialistaMapper especialistaMapper;

    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_SIZE = 25;

    public EspecialistaDTO createEspecialista(EspecialistaDTO especialistaDto) {
        Especialista especialista = especialistaMapper.especialistaDtoToEspecialista(especialistaDto);
        especialista.setId(UUID.randomUUID().toString());
        especialistaRepository.save(especialista);
        return especialistaMapper.especialistaToEspecialistaDto(especialista);
    }

    public EspecialistaDTO getEspecialista(String id) {
        Especialista especialista = especialistaRepository.getEspecialistaById(id);
        EspecialistaDTO especialistaDTO = especialistaMapper.especialistaToEspecialistaDto(especialista);
        return especialistaDTO;
    }

    public EspecialistaDTO updateEspecialista(EspecialistaDTO especialistaDto) {
        return null;
    }

    public List<EspecialistaDTO> getEspecialistas() {
        return especialistaRepository.findAll().stream().map(especialistaMapper::especialistaToEspecialistaDto).toList();
    }

    public void deleteById(UUID id) {

    }
}

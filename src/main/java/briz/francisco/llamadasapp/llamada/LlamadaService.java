package briz.francisco.llamadasapp.llamada;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LlamadaService {

    private final LlamadaRepository llamadaRepository;
    private final LlamadaMapper llamadaMapper;

    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_SIZE = 25;

    public LlamadaDTO createLlamada(LlamadaDTO LlamadaDTO) {
        Llamada llamada = llamadaMapper.llamadaDtoToLlamada(LlamadaDTO);
        llamada.setId(UUID.randomUUID().toString());
        llamada.setFechaHora(new Timestamp(System.currentTimeMillis()));
        if (llamada.getEsBroma() == null) {
            llamada.setEsBroma(false);
        }


        System.out.println(llamada);
        llamadaRepository.save(llamada);
        return llamadaMapper.llamadaToLlamadaDto(llamada);
    }


    public LlamadaDTO getLlamada(String id) {

        return llamadaMapper.llamadaToLlamadaDto(llamadaRepository.getLlamadaById(id));
    }

    public List<LlamadaDTO> getLlamadasByEspecialistaId(String id) {
        return llamadaRepository.getLlamadasByEspercialistaIdAndComentarioNull(id).stream().map(llamadaMapper::llamadaToLlamadaDto).toList();
    }

    public void updateLlamada(LlamadaDTO llamadaDTO) {
        Llamada llamada = llamadaMapper.llamadaDtoToLlamada(llamadaDTO);
        llamadaRepository.udpdate(llamada);
    }

    public List<LlamadaDTO> getLlamadas() {
        return llamadaRepository.findAll().stream().map(llamadaMapper::llamadaToLlamadaDto).toList();
    }

    public void deleteById(UUID id) {

//        llamadaRepository.deleteById(id);
    }
}

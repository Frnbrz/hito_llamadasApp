package briz.francisco.llamadasapp.paciente;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;

    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_SIZE = 25;

    public PacienteDTO createPaciente(PacienteDTO pacienteDto) {
//        return pacienteMapper.pacienteToPacienteDto(pacienteRepository.save(pacienteMapper.pacienteDtoToPaciente(pacienteDto)));
        return null;

    }

    public PacienteDTO getPaciente(String id) {

        return pacienteMapper.pacienteToPacienteDto(pacienteRepository.getPacienteById(id));


    }

    public PacienteDTO updatePaciente(PacienteDTO pacienteDto) {
//        return pacienteMapper.pacienteToPacienteDto(pacienteRepository.save(pacienteMapper.pacienteDtoToPaciente(pacienteDto)));
        return null;

    }

    public List<PacienteDTO> getPacientes() {
        return pacienteRepository.findAll().stream().map(pacienteMapper::pacienteToPacienteDto).toList();
    }

    public void deleteById(UUID id) {
//        pacienteRepository.deleteById(id);

    }
}

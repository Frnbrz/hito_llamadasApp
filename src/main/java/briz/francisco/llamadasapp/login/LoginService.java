package briz.francisco.llamadasapp.login;

import briz.francisco.llamadasapp.especialista.Especialista;
import briz.francisco.llamadasapp.especialista.EspecialistaRepository;
import briz.francisco.llamadasapp.operador.Operador;
import briz.francisco.llamadasapp.operador.OperadorRepository;
import briz.francisco.llamadasapp.shared.TipoTrabajador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {


    private final EspecialistaRepository especialistaRepository;
    private final OperadorRepository operadorRepository;

    public LoginDTO getLoginByEmail(String userEmail) {

        Especialista especialista = especialistaRepository.getEspecialistaByEmail(userEmail);
        Operador operador = operadorRepository.getOperadorByEmail(userEmail);
        if (especialista != null) {
            return LoginDTO.builder()
                    .id(especialista.getId())
                    .email(especialista.getEmail())
                    .tipoTrabajador(TipoTrabajador.ESPECIALISTA)
                    .build();
        } else if (operador != null) {
            return LoginDTO.builder()
                    .id(operador.getId())
                    .email(operador.getEmail())
                    .tipoTrabajador(TipoTrabajador.OPERADOR)
                    .build();

        } else {
           return null;
        }
    }
}

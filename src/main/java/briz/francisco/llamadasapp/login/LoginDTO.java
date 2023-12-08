package briz.francisco.llamadasapp.login;

import briz.francisco.llamadasapp.shared.TipoTrabajador;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class LoginDTO {

    private String id;
    private String email;
    private TipoTrabajador tipoTrabajador;
}

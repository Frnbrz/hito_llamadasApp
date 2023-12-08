package briz.francisco.llamadasapp.operador;

import briz.francisco.llamadasapp.llamada.Llamada;
import briz.francisco.llamadasapp.shared.Turno;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@Table(name = "operador")
@NoArgsConstructor
@AllArgsConstructor
public class Operador {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(length = 100)
    private String nombre;


    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(length = 100)
    private String apellido;


    @NotNull
    @NotBlank
    @Size(max = 100)

    private String email;

    @Size(max = 100)
    @Column(length = 100)
    private String direccion;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private Turno turno;


    @OneToMany(mappedBy = "operador")
    private List<Llamada> llamadas;


}

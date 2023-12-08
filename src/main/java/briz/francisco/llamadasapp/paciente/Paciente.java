package briz.francisco.llamadasapp.paciente;

import briz.francisco.llamadasapp.llamada.Llamada;
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
@Table(name = "paciente")
@NoArgsConstructor
@AllArgsConstructor

public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(length = 100)
    private String dni;


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

    @Size(max = 100)
    @Column(length = 100)
    private String direccion;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(length = 100)
    private String telefono;


    @OneToMany(mappedBy = "paciente")
    private List<Llamada> llamadas;
}

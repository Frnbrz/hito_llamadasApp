package briz.francisco.llamadasapp.llamada;

import briz.francisco.llamadasapp.paciente.Paciente;
import briz.francisco.llamadasapp.especialista.Especialista;
import briz.francisco.llamadasapp.interaccion.Interaccion;
import briz.francisco.llamadasapp.operador.Operador;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@Table(name = "llamada")
@NoArgsConstructor
@AllArgsConstructor
public class Llamada {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Column(columnDefinition = "BOOLEAN DEFAULT false",name = "es_broma")
    private Boolean esBroma;

    @Column(name = "fecha_hora")
    private Timestamp fechaHora;

    @Column(columnDefinition="TEXT")
    private String comentario;


    @Column(name = "operador_id")
    private String operadorId;

    @Column(name = "especialista_id")
    private String especialistaId;

    @Column(name = "paciente_id")
    private String pacienteId;

    @OneToMany(mappedBy = "llamada")
    private List<Interaccion> interacciones;

    @ManyToOne

    @JoinColumn(insertable = false, updatable = false)
    private Operador operador;


    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)

    private Especialista especialista;

    @ManyToOne

    @JoinColumn(insertable = false, updatable = false)
    private Paciente paciente;
}

package briz.francisco.llamadasapp.interaccion;

import briz.francisco.llamadasapp.llamada.Llamada;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@Table(name = "interaccion")
@NoArgsConstructor
@AllArgsConstructor
public class Interaccion {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "fecha_hora")
    private Timestamp fechaHora;

    @Column(columnDefinition="TEXT")
    private String pregunta;

    @Column(columnDefinition="TEXT")
    private String respuesta;

    @Column(name = "llamada_id")
    private String llamadaId;

    @ManyToOne

    @JoinColumn(insertable = false, updatable = false)
    @JsonManagedReference
    private Llamada llamada;


}

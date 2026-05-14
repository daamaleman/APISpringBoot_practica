package ni.edu.uam.registroEstudiantes_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "proyecto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Proyect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto")
    private Long id;

    @Column(name = "nombre_proyecto", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion_proyecto", nullable = false, length = 100)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante")
    @JsonIgnore
    private Student student;
}

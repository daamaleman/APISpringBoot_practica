package ni.edu.uam.registroEstudiantes_api.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "estudiante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long id;

    @Column(name = "nombre_estudiante", nullable = false, length = 100)
    private String nombre;

    @Column(name = "carrera_estudiante", nullable = false, length = 100)
    private String carrera;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Proyect> proyectos;

}

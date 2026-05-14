package ni.edu.uam.registroEstudiantes_api.repository;

import ni.edu.uam.registroEstudiantes_api.models.Proyect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectRepo extends JpaRepository<Proyect, Long> {
}

package ni.edu.uam.registroEstudiantes_api.repository;

import ni.edu.uam.registroEstudiantes_api.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {

}

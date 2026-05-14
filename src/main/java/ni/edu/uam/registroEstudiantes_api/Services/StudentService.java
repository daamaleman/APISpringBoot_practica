package ni.edu.uam.registroEstudiantes_api.Services;

import ni.edu.uam.registroEstudiantes_api.models.Proyect;
import ni.edu.uam.registroEstudiantes_api.models.Student;
import ni.edu.uam.registroEstudiantes_api.repository.StudentRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(@PathVariable Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    public Student saveStudent(Student student) {
        if (student.getProyectos() != null) {
            for (Proyect p : student.getProyectos()) {
                p.setStudent(student);
            }
        }
        return studentRepo.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

}

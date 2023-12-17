package freelance.assigment.student.mgt.repository;
import freelance.assigment.student.mgt.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

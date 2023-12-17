package freelance.assigment.student.mgt.repository;

import freelance.assigment.student.mgt.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

package freelance.assigment.student.mgt.repository.studentcourse;

import freelance.assigment.student.mgt.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
}
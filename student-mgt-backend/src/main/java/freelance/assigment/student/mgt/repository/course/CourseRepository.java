package freelance.assigment.student.mgt.repository.course;

import freelance.assigment.student.mgt.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Long> {
    Course findByCourseUuid(String courseUuid);
}
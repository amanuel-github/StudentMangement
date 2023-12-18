package freelance.assigment.student.mgt.service.studentcourse;

import freelance.assigment.student.mgt.dto.request.StudentCourseRequest;
import freelance.assigment.student.mgt.dto.response.StudentCourseResponse;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface StudentCourseService {
    public ResponseEntity<?> createStudentCourse(StudentCourseRequest studentCourseRequest);
    public ResponseEntity<?> updateStudentCourse(String studentCourseUuid, StudentCourseRequest studentCourseRequest);
    public ResponseEntity<?> deleteStudentCourse(String studentCourseUuid);
    public List<StudentCourseResponse> getStudentCourses(int page, int limit);
    public StudentCourseResponse getStudentCourse(String studentCourseUuid);
}

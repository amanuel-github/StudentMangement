package freelance.assigment.student.mgt.service.Course;


import freelance.assigment.student.mgt.dto.request.CourseRequest;
import freelance.assigment.student.mgt.dto.response.CourseResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {
    public ResponseEntity<?> createCourse(CourseRequest courseRequest);
    public ResponseEntity<?> updateCourse(String courseUuid, CourseRequest courseRequest);
    public ResponseEntity<?> deleteCourse(String courseUuid);
    public List<CourseResponse> getCourses(int page, int limit);
    public CourseResponse getCourse(String courseUuid);
}

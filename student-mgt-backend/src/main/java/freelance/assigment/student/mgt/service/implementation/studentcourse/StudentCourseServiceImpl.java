package freelance.assigment.student.mgt.service.implementation.studentcourse;

import freelance.assigment.student.mgt.dto.request.StudentCourseRequest;
import freelance.assigment.student.mgt.dto.response.MessageResponse;
import freelance.assigment.student.mgt.dto.response.StudentCourseResponse;
import freelance.assigment.student.mgt.entity.StudentCourse;
import freelance.assigment.student.mgt.repository.studentcourse.StudentCourseRepository;
import freelance.assigment.student.mgt.service.studentcourse.StudentCourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    @Autowired
    StudentCourseRepository studentCourseRepository;
    @Override
    public ResponseEntity<?> createStudentCourse(StudentCourseRequest studentCourseRequest) {
        StudentCourse studentCourse = new StudentCourse();
        BeanUtils.copyProperties(studentCourseRequest,studentCourse);
        studentCourseRepository.save(studentCourse);
        return ResponseEntity.ok(new MessageResponse("Student course saved successfully!"));
    }

    @Override
    public ResponseEntity<?> updateStudentCourse(String studentCourseUuid, StudentCourseRequest studentCourseRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteStudentCourse(String studentCourseUuid) {
        return null;
    }

    @Override
    public List<StudentCourseResponse> getStudentCourses(int page, int limit) {
        return null;
    }

    @Override
    public StudentCourseResponse getStudentCourse(String studentCourseUuid) {
        return null;
    }
}

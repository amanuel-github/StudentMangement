package freelance.assigment.student.mgt.controller.studentcourse;

import freelance.assigment.student.mgt.dto.request.StudentCourseRequest;
import freelance.assigment.student.mgt.service.studentcourse.StudentCourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


    @CrossOrigin("*")
    @RestController
    @RequestMapping("/api/studentCourses")
    @AllArgsConstructor
    public class StudentCourseController {
        @Autowired
        private StudentCourseService studentCourseService;

        @PostMapping
        public ResponseEntity<?> createStudentCourse(@Valid @RequestBody StudentCourseRequest studentCourseRequest) {
            return studentCourseService.createStudentCourse(studentCourseRequest);

        }

    }

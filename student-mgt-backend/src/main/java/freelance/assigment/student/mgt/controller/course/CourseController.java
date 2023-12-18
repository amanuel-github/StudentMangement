package freelance.assigment.student.mgt.controller.course;

import freelance.assigment.student.mgt.dto.request.CourseRequest;
import freelance.assigment.student.mgt.dto.response.CourseResponse;
import freelance.assigment.student.mgt.service.Course.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping
    public ResponseEntity<?> createCourse(@Valid @RequestBody CourseRequest courseRequest) {
        return courseService.createCourse(courseRequest);

    }

    @PutMapping(path = "/{courseUuid}")
    public ResponseEntity<?> updateCourse(@PathVariable String courseUuid, @Valid @RequestBody CourseRequest courseRequest) {
        return courseService.updateCourse(courseUuid, courseRequest);
    }

    @GetMapping(path = "/{courseUuid}")
    public CourseResponse getCourse(@PathVariable String courseUuid) {
        return courseService.getCourse(courseUuid);
    }

    @GetMapping()
    public List<CourseResponse> getCourses(@RequestParam(value = "page", defaultValue = "1") int page,
                                           @RequestParam(value = "limit", defaultValue = "25") int limit) {
        return courseService.getCourses(page, limit);
    }

    @DeleteMapping(path = "/{courseUuid}")
    public ResponseEntity<?> deleteCourse(@PathVariable String courseUuid) {
        return courseService.deleteCourse(courseUuid);
    }
}
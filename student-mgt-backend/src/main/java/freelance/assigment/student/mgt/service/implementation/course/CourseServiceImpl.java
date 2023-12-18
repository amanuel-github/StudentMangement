package freelance.assigment.student.mgt.service.implementation.course;

import freelance.assigment.student.mgt.dto.request.CourseRequest;
import freelance.assigment.student.mgt.dto.response.CourseResponse;
import freelance.assigment.student.mgt.dto.response.MessageResponse;
import freelance.assigment.student.mgt.entity.Course;
import freelance.assigment.student.mgt.repository.course.CourseRepository;
import freelance.assigment.student.mgt.service.Course.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Override
    public ResponseEntity<?> createCourse(CourseRequest courseRequest) {
        Course course = new Course();
        BeanUtils.copyProperties(courseRequest,course);
        courseRepository.save(course);
        return ResponseEntity.ok(new MessageResponse("Course saved successfully!"));
    }

    @Override
    public ResponseEntity<?> updateCourse(String courseUuid, CourseRequest courseRequest) {
        Course course = courseRepository.findByCourseUuid(courseUuid);

        BeanUtils.copyProperties(courseRequest,course);
        courseRepository.save(course);
        return ResponseEntity.ok(new MessageResponse("Course Updated Successfully!"));
    }

    @Override
    public ResponseEntity<?> deleteCourse(String courseUuid) {
        Course course = courseRepository.findByCourseUuid(courseUuid);
        if(course == null)
            throw new RuntimeException("Course not found.");
        course.setDeleted(true);
        courseRepository.save(course);
        return ResponseEntity.ok(new MessageResponse("Course  soft deleted successfully!"));
    }

    @Override
    public List<CourseResponse> getCourses(int page, int limit) {
        if(page > 0) page = page - 1;
        Pageable pageRequest = PageRequest.of(page, limit, Sort.by("id").descending());
        Page<Course> coursePage = courseRepository.findAll(pageRequest);
        long totalPages = coursePage.getTotalPages();
        List<Course> courseList = coursePage.getContent();
        List<CourseResponse> courseResponse = new ArrayList<>();
        for (Course c : courseList) {
            CourseResponse cr = new CourseResponse();
            if(courseResponse.size() == 0)
                cr.setTotalPages(totalPages);
            BeanUtils.copyProperties(c, cr);
            courseResponse.add(cr);
        }
        return courseResponse;
    }

    @Override
    public CourseResponse getCourse(String courseUuid) {
        Course course = courseRepository.findByCourseUuid(courseUuid);
        CourseResponse courseResponse = new CourseResponse();
        BeanUtils.copyProperties(course, courseResponse);
        return courseResponse;
    }
}

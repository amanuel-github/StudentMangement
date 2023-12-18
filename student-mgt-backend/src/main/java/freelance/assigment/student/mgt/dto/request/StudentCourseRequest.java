package freelance.assigment.student.mgt.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentCourseRequest {


    private String  studentUuid;


    private String courseUuid;
}

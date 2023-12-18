package freelance.assigment.student.mgt.dto.response;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentCourseResponse {


    private String  studentUuid;


    private String courseUuid;
}

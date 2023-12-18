package freelance.assigment.student.mgt.dto.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter
    public class CourseRequest {


        private String description;


        private String courseType;

        private String duration;


        private String courseTopics;


}

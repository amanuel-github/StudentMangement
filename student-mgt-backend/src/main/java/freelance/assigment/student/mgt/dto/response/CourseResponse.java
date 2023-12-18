package freelance.assigment.student.mgt.dto.response;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter
    public class CourseResponse {


        @NotBlank
        @Column(name = "description")
        private String description;

        @NotBlank
        @Column(name = "course_type")
        private String courseType;

        @NotBlank
        @Column(name = "duration")
        private String duration;

        @NotBlank
        @Column(name = "course_topics")
        private String courseTopics;

        private long totalPages;


}

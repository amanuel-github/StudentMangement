package freelance.assigment.student.mgt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
}

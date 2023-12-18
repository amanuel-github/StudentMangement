package freelance.assigment.student.mgt.entity;

import freelance.assigment.student.mgt.shared.audit.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses" ,uniqueConstraints = {
        @UniqueConstraint(columnNames = "courseUuid")})

public class Course extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 36, max = 40)
    private String courseUuid = UUID.randomUUID().toString();

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

    @ManyToMany(mappedBy = "takenCourses")
    Set<Student> takes = new HashSet<>();


    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;
}

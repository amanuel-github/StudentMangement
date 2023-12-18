package freelance.assigment.student.mgt.entity;
import freelance.assigment.student.mgt.shared.audit.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

import jakarta.validation.constraints.Size;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students" ,uniqueConstraints = { @UniqueConstraint(columnNames = "email"),
        }

)
public class Student extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String  studentUuid = UUID.randomUUID().toString();

       @ManyToMany
       @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "studentUuid"),
            inverseJoinColumns = @JoinColumn(name = "courseUuid"))
    Set<Course> takenCourses = new HashSet<>();


    private Date dateOfBirth;

    private String firstName;


    private String lastName;



    private String email;

    private String mobilePhone;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}

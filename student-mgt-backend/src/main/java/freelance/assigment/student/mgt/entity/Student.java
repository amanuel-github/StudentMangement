package freelance.assigment.student.mgt.entity;
import freelance.assigment.student.mgt.shared.audit.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

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

    @Past(message = "date must be in the past")
    private Date dateOfBirth;

    @NotEmpty
    @Size(max = 100)
    private String firstName;

    @NotEmpty
    @Size(max = 100)
    private String lastName;


    @NotBlank
    @Email(message = "Email is not valid")
    private String email;

    private String mobilePhone;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}

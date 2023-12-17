package freelance.assigment.student.mgt.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jakarta.validation.constraints.Size;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students" ,uniqueConstraints = { @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "studentUuid"), @UniqueConstraint(columnNames = "mobilePhone")}

)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 36, max = 40)
    private String  studentUuid = UUID.randomUUID().toString();

    @Column(name = "Dob" , nullable = false, length=100)
    private String dateOfBirth;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Address> address = new ArrayList<>();

    @NotBlank
    @Column(name = "email")
    private String email;

    @NotBlank
    private String mobilePhone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}

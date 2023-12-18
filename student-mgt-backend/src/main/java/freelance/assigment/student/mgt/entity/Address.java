package freelance.assigment.student.mgt.entity;

import freelance.assigment.student.mgt.shared.audit.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "adresses")
public class Address extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 36, max = 40)
    private String addressUuid = UUID.randomUUID().toString();

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "area")
    private String area;

    @Column(name = "pin_code")
    private String pinCode;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_id")
    private Student student;
}

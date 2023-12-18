package freelance.assigment.student.mgt.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
public class StudentRequest {

    private String  studentUuid ;




    private Date dateOfBirth;


    private String firstName;


    private String lastName;



    private String email;

    private String mobilePhone;
}

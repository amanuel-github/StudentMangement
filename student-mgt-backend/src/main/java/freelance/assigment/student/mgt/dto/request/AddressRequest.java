package freelance.assigment.student.mgt.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressRequest {
    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "area")
    private String area;

    @Column(name = "pin_code")
    private String pinCode;
}

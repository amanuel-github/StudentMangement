package freelance.assigment.student.mgt.service.adress;


import freelance.assigment.student.mgt.dto.request.AddressRequest;
import freelance.assigment.student.mgt.dto.response.AddressResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AddressService {
    public ResponseEntity<?> createAddress(AddressRequest addressRequest);
    public ResponseEntity<?> updateAddress(String addressUuid, AddressRequest addressRequest);
    public ResponseEntity<?> deleteAddress(String addressUuid);
    public List<AddressResponse> getAddresses(int page, int limit);
    public AddressResponse getAddress(String addressUuid);
}

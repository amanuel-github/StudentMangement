package freelance.assigment.student.mgt.controller.adress;

import freelance.assigment.student.mgt.dto.StudentDto;
import freelance.assigment.student.mgt.dto.request.AddressRequest;
import freelance.assigment.student.mgt.dto.response.AddressResponse;
import freelance.assigment.student.mgt.service.adress.AddressService;
import freelance.assigment.student.mgt.service.student.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressController {

    @Autowired
    AddressService addressService;
    @PostMapping
    public ResponseEntity<?> createAddress(@Valid @RequestBody AddressRequest addressRequest) {
        return addressService.createAddress(addressRequest);

    }

    @PutMapping(path="/{addressUuid}")
    public ResponseEntity<?> updateAddress(@PathVariable String addressUuid, @Valid @RequestBody AddressRequest addressRequest) {
        return addressService.updateAddress(addressUuid, addressRequest);
    }

    @GetMapping(path="/{addressUuid}")
    public AddressResponse getAddress(@PathVariable String addressUuid) {
        return addressService.getAddress(addressUuid);
    }

    @GetMapping("/all")
    public List<AddressResponse > getAddresses(@RequestParam(value="page", defaultValue = "1") int page,
                                           @RequestParam(value="limit", defaultValue = "25") int limit) {
        return addressService.getAddresses(page,limit);
    }

    @DeleteMapping(path="/{addressUuid}")
    public ResponseEntity<?> deleteAddress(@PathVariable String addressUuid) {
        return addressService.deleteAddress(addressUuid);
    }
}
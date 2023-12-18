package freelance.assigment.student.mgt.service.implementation.adress;

import freelance.assigment.student.mgt.dto.request.AddressRequest;
import freelance.assigment.student.mgt.dto.response.AddressResponse;
import freelance.assigment.student.mgt.dto.response.MessageResponse;
import freelance.assigment.student.mgt.entity.Address;
import freelance.assigment.student.mgt.exception.ResourceNotFoundException;
import freelance.assigment.student.mgt.repository.adress.AddressRepository;
import freelance.assigment.student.mgt.service.adress.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Override
    public ResponseEntity<?> createAddress(AddressRequest addressRequest) {
        Address address = new  Address();
        BeanUtils.copyProperties(addressRequest, address);
        addressRepository.save(address);
        return ResponseEntity.ok(new MessageResponse("Address saved successfully!"));
    }

    @Override
    public ResponseEntity<?> updateAddress(String addressUuid, AddressRequest addressRequest) {
        Address address = addressRepository.findByAddressUuid(addressUuid);

        BeanUtils.copyProperties(addressRequest,address);
        addressRepository.save(address);
        return ResponseEntity.ok(new MessageResponse("Address Updated Successfully!"));
    }

    @Override
    public ResponseEntity<?> deleteAddress(String addressUuid) {
        Address address = addressRepository.findByAddressUuid(addressUuid);
        if(address == null)
            throw new ResourceNotFoundException("Address not found.");
        address.setDeleted(true);
        addressRepository.save(address);
        return ResponseEntity.ok(new MessageResponse("Address soft deleted successfully!"));
    }

    @Override
    public List<AddressResponse> getAddresses(int page, int limit) {
        if(page > 0) page = page - 1;
        Pageable pageRequest = PageRequest.of(page, limit, Sort.by("id").descending());
        Page<Address> addressPage = addressRepository.findAll(pageRequest);
        long totalPages = addressPage.getTotalPages();
        List<Address> addressList = addressPage.getContent();
        List<AddressResponse> addressResponse = new ArrayList<>();
        for (Address a : addressList) {
            AddressResponse ar = new AddressResponse();
            if(addressResponse.size() == 0)
                ar.setTotalPages(totalPages);
            BeanUtils.copyProperties(a, ar);
            addressResponse.add(ar);
        }
        return addressResponse;
    }

    @Override
    public AddressResponse getAddress(String addressUuid) {
        Address address= addressRepository.findByAddressUuid(addressUuid);
        AddressResponse addressResponse = new AddressResponse();
        BeanUtils.copyProperties(address, addressResponse);
        return addressResponse;
    }
}

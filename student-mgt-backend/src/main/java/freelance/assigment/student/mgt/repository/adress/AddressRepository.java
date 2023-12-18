package freelance.assigment.student.mgt.repository.adress;

import freelance.assigment.student.mgt.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository  extends JpaRepository<Address, Long> {
    Address findByAddressUuid(String answerUuid);
}
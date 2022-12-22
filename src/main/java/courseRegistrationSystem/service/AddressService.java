package courseRegistrationSystem.service;

import courseRegistrationSystem.domain.Address;
import courseRegistrationSystem.domain.Student;
import courseRegistrationSystem.dto.AddressDTO;
import courseRegistrationSystem.dto.StudentDTO;

import java.util.List;

public interface AddressService {

    List<AddressDTO> getAllAddress();
    AddressDTO getAddressBy_Id(Long addressId);

    AddressDTO addNewAddress(Address address);
}

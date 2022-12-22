package courseRegistrationSystem.service.impl;

import courseRegistrationSystem.domain.Address;
import courseRegistrationSystem.dto.AddressDTO;
import courseRegistrationSystem.repository.AddressRepository;
import courseRegistrationSystem.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<AddressDTO> getAllAddress() {
        return addressRepository.findAll().stream().map(address ->
                modelMapper.map(address,AddressDTO.class)).collect(Collectors.toList());
    }

    @Override
    public AddressDTO getAddressBy_Id(Long addressId) {
        return modelMapper.map(addressRepository.findById(addressId),AddressDTO.class);
    }

    @Override
    public AddressDTO addNewAddress(Address address) {
        return modelMapper.map(addressRepository.save(address),AddressDTO.class);
    }
}

package courseRegistrationSystem.service.impl;


import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.dto.MapperRegistration;
import courseRegistrationSystem.dto.MapperRegistrationDto;
import courseRegistrationSystem.dto.RegistrationDTO;
import courseRegistrationSystem.dto.RegistrationEventDTO;
import courseRegistrationSystem.repository.RegistrationRepository;
import courseRegistrationSystem.service.RegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private MapperRegistration mapper;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RegistrationDTO> getAllRegisters() {
        return registrationRepository.findAll()
                .stream().map(entity-> modelMapper.map(entity,RegistrationDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RegistrationDTO getRegistrationBy_Id(Long registrationId) {

       return registrationRepository.findById(registrationId)
               .stream().map(entiy->{
                   return mapper.mapTo(entiy);
               }).findFirst().orElse(null);

    }

    @Override
    public RegistrationDTO addNewRegistration(Registration registration) {

        return  modelMapper.map(registrationRepository.save(registration),RegistrationDTO.class);
    }

    @Override
    public RegistrationDTO updateRegistration(Long registrationId, Registration registration) {
        Optional<Registration> reg = registrationRepository.findById(registrationId);
        Registration updateRegistration=null;
        if (reg.isPresent()){
            updateRegistration= reg.stream().map(
                    newRegistration->{
                        newRegistration.setRegistrationId(registration.getRegistrationId());
                        newRegistration.setStudent(registration.getStudent());
                        newRegistration.setCourseOffering(registration.getCourseOffering());
                        return newRegistration;
                    }).findFirst().get();
             registrationRepository.save(updateRegistration);
        }
        return  modelMapper.map(registrationRepository,RegistrationDTO.class);
    }
    @Override
    public void deleteById(Long registrationId) {
      registrationRepository.deleteById(registrationId);
    }
}

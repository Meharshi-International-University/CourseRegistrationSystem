package courseRegistrationSystem.service.impl;


import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.dto.MapperRegistration;
import courseRegistrationSystem.dto.MapperRegistrationDto;
import courseRegistrationSystem.dto.RegistrationDTO;
import courseRegistrationSystem.repository.RegistrationRepository;
import courseRegistrationSystem.service.RegistrationService;
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
    private MapperRegistrationDto mapperDto;

    @Override
    public List<RegistrationDTO> getAllRegisters() {
        return registrationRepository.findAll()
                .stream().map(entity->{
                  return mapper.mapTo(entity);
                }).collect(Collectors.toList());
    }

    @Override
    public RegistrationDTO getRegistrationBy_Id(Long registrationId) {

       return registrationRepository.findById(registrationId)
               .stream().map(entiy->{
                   return mapper.mapTo(entiy);
               }).findFirst().orElse(null);

    }

    @Override
    public void addNewRegistration(RegistrationDTO registrationDto) {
       Registration newDto= mapperDto.mapTo(registrationDto);
         registrationRepository.save(newDto);
    }

    @Override
    public void updateRegistration(Long registrationId, RegistrationDTO registration) {
        Optional<Registration> reg = registrationRepository.findById(registrationId);
        if (reg.isPresent()){
            Registration r = reg.get();

             r.setCourseOffering(registration.getCourseOfferingDTO());
             r.setStudent(registration.getStudent());
             registrationRepository.save(r);
        }
    }
//    @Override
//    public Registration updateRegistration(Long registrationId, RegistrationDTO registration) {
//        Optional<Registration> reg = registrationRepository.findById(registrationId);
//        if (reg.isPresent()){
//            // Do something
//            // return Registrations
//        }
//        return null

    @Override
    public void deleteById(Long registrationId) {
      registrationRepository.deleteById(registrationId);
    }
}

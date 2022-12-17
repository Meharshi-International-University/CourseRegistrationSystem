package courseRegistrationSystem.service;


import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.dto.RegistrationDto;

import java.util.List;

public interface RegistrationService {

    List<RegistrationDto> getAllRegisters();
    RegistrationDto getRegistrationBy_Id(Long registrationId);
    Registration addNewRegistration(RegistrationDto registration);
    Registration updateRegistration(Long registrationId, RegistrationDto registration);
    void deleteById(Long registrationId);

    //List<Registration> searchJob(String searchJob, String searchJob1);
}



package courseRegistrationSystem.service;


import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.dto.RegistrationDTO;

import java.util.List;

public interface RegistrationService {

    List<RegistrationDTO> getAllRegisters();
    RegistrationDTO getRegistrationBy_Id(Long registrationId);
    RegistrationDTO addNewRegistration(Registration registration);
    RegistrationDTO updateRegistration(Long registrationId, Registration registration);
    void deleteById(Long registrationId);

    //List<Registration> searchJob(String searchJob, String searchJob1);
}



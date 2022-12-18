package courseRegistrationSystem.service;


import courseRegistrationSystem.dto.RegistrationDTO;

import java.util.List;

public interface RegistrationService {

    List<RegistrationDTO> getAllRegisters();
    RegistrationDTO getRegistrationBy_Id(Long registrationId);
    void addNewRegistration(RegistrationDTO registration);
    void updateRegistration(Long registrationId, RegistrationDTO registration);
    void deleteById(Long registrationId);

    //List<Registration> searchJob(String searchJob, String searchJob1);
}



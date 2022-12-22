package courseRegistrationSystem.service;

import courseRegistrationSystem.domain.RegistrationRequest;
import courseRegistrationSystem.dto.RegistrationRequestDTO;
import courseRegistrationSystem.dto.RegistrationRequestListDTO;

import java.util.List;


public interface RegistrationRequestService {

    void saveRegistrationRequests(Long studentId, RegistrationRequestListDTO registrationRequestListDTO);


     RegistrationRequest getRegistrationRequest(Long id);


    List<RegistrationRequest> getRegistrationRequestByStudent(Long studentId);
}
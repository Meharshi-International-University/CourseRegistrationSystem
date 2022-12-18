package courseRegistrationSystem.service;

import courseRegistrationSystem.domain.RegistrationRequest;
import courseRegistrationSystem.dto.RegistrationRequestDTO;

import java.util.List;


public interface RegistrationRequestService {

    void saveRegistrationRequests(String studentId,List<RegistrationRequestDTO> registrationRequestDtos);


    public void updateRegistrationRequest(Long id,RegistrationRequestDTO registrationRequestDto);


    public void deleteRegistrationRequest(Long id);


    public RegistrationRequest getRegistrationRequest(Long id);


}
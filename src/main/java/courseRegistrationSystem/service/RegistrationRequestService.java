package courseRegistrationSystem.service;

import courseRegistrationSystem.domain.RegistrationRequest;
import courseRegistrationSystem.dto.RegistrationRequestDTO;


public interface RegistrationRequestService {

    public void saveRegistrationRequest(RegistrationRequestDTO registrationRequestDto);


    public void updateRegistrationRequest(Long id,RegistrationRequestDTO registrationRequestDto);


    public void deleteRegistrationRequest(Long id);


    public RegistrationRequest getRegistrationRequest(Long id);
}
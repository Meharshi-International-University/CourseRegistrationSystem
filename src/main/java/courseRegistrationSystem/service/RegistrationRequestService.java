package courseRegistrationSystem.service;

import courseRegistrationSystem.domain.RegistrationRequest;
import courseRegistrationSystem.dto.RegistrationRequestDto;

public interface RegistrationRequestService {

    public void saveRegistrationRequest(RegistrationRequestDto registrationRequestDto);


    public RegistrationRequest updateRegistrationRequest(Long id,RegistrationRequestDto registrationRequestDto);


    public void deleteRegistrationRequest(Long id);


    public RegistrationRequest getRegistrationRequest(Long id);
}

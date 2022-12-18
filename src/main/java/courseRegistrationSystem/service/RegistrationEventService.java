package courseRegistrationSystem.service;

import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.dto.RegistrationDTO;
import courseRegistrationSystem.dto.RegistrationEventDTO;
import courseRegistrationSystem.repository.RegistrationEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RegistrationEventService {

    List<RegistrationEventDTO> getAllRegistrationEvents();
    RegistrationEventDTO getRegistrationEventBy_Id(Long registrationEventId);
    RegistrationEventDTO addNewRegistrationEvent(RegistrationEventDTO registrationEventDTO);
    RegistrationEventDTO updateRegistrationEvent(Long registrationId, RegistrationEventDTO registrationEventDTO);
    void deleteById(Long registrationEventId);

}

package courseRegistrationSystem.service;

import courseRegistrationSystem.dto.RegistrationEventDTO;

import java.util.List;

public interface RegistrationEventService {

    List<RegistrationEventDTO> getAllRegistrationEvents();
    RegistrationEventDTO getRegistrationEventBy_Id(Long registrationEventId);
    RegistrationEventDTO addNewRegistrationEvent(RegistrationEventDTO registrationEventDTO);
    RegistrationEventDTO updateRegistrationEvent(Long registrationId, RegistrationEventDTO registrationEventDTO);
    void deleteById(Long registrationEventId);

}

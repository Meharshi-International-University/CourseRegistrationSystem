package courseRegistrationSystem.service;

import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.dto.RegistrationEventDTO;
import courseRegistrationSystem.enums.RegistrationEventStatus;

import java.util.List;
import java.util.Optional;

public interface RegistrationEventService {

    List<RegistrationEventDTO> getAllRegistrationEvents();
    RegistrationEventDTO  getRegistrationEventBy_Id(Long registrationEventId);
    RegistrationEventDTO addNewRegistrationEvent(RegistrationEvent registrationEvent);
    RegistrationEventDTO updateRegistrationEvent(Long registrationId, RegistrationEvent registrationEvent);
    void deleteById(Long registrationEventId);
    RegistrationEventDTO registrationStatus(RegistrationEventStatus status);

}

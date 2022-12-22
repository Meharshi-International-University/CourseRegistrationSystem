package courseRegistrationSystem.service;

import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.dto.RegistrationEventDTO;

import java.util.List;
import java.util.Optional;

public interface RegistrationEventService {

    RegistrationEvent findAllByEndDateDescOrder(Long id);
    List<RegistrationEventDTO> getAllRegistrationEvents();
    RegistrationEventDTO  getRegistrationEventBy_Id(Long registrationEventId);
    //RegistrationEvent  getRegistrationEventStudentIdCheck(Long studentId);
    RegistrationEventDTO addNewRegistrationEvent(RegistrationEvent registrationEvent);
    //RegistrationEventDTO updateRegistrationEvent(Long registrationId, RegistrationEvent registrationEvent);
    void deleteById(Long registrationEventId);
    //RegistrationEventDTO registrationStatus(RegistrationEventStatus status);

    //RegistrationEventDTO getRegistrationEventsByStudentId(Long studentId);

}

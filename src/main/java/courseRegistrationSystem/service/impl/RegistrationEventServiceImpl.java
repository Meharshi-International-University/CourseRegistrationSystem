package courseRegistrationSystem.service.impl;

import courseRegistrationSystem.repository.RegistrationEventRepository;
import courseRegistrationSystem.service.RegistrationEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationEventServiceImpl implements RegistrationEventService {
    @Autowired
    RegistrationEventRepository registrationEventRepository;

}

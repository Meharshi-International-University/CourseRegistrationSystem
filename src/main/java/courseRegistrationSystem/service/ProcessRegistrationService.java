package courseRegistrationSystem.service;

import org.springframework.stereotype.Service;

@Service
public interface ProcessRegistrationService {

    void processRegistration(Long id);

    boolean checkPrequisiteIsMet(Long courseOfferingCode);
}

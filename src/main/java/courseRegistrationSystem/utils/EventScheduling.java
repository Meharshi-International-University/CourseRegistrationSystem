package courseRegistrationSystem.utils;

import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.repository.RegistrationEventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class EventScheduling {
    @Autowired
    private EmailService emailService;

    @Autowired
    private RegistrationEventRepository registrationEventRepository;

    // @Scheduled(fixedRate=4*60*60*1000)
    @Scheduled(fixedRate = 240000)
    public void checkEventSchedule() {
        log.info("inside checkEventSchedule method of Event Scheduling");
        getRegistrationEvent().stream().forEach(event ->
                emailService.sendToEmailService("eventReminder", event.toString())
        );

    }

    private List<Long> getRegistrationEvent() {
        log.info("inside getRegistrationEvent method of EventScheduling ");
        List<RegistrationEvent> registrationEvents = registrationEventRepository.getRegistrationByToday(LocalDateTime.now());
        List<Long> registrationList = new ArrayList<>();
        registrationEvents.forEach(registrationEvent -> {
            Long diffHours = Duration.between(LocalDateTime.now(), registrationEvent.getEndDate()).toHours();
            if ((8>= diffHours && diffHours <4) ||  diffHours<= 4) {
                registrationList.add(registrationEvent.getId());
            }
        });
        return registrationList;
    }
}

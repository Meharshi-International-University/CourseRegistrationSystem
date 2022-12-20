package courseRegistrationSystem.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventScheduling {
    @Autowired
    private EmailService emailService;

    @Scheduled(fixedRate = 100000000)
    public void checkEventSchedule(){
        log.info("inside checkEventSchedule method of Event Scheduling");
        //TODO
       // emailService.sendToEmailService("eventReminder","Save the message");
    }
}

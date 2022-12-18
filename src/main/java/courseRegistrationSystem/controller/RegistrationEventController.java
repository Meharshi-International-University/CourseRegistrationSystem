package courseRegistrationSystem.controller;

import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.dto.RegistrationDTO;
import courseRegistrationSystem.dto.RegistrationEventDTO;
import courseRegistrationSystem.service.RegistrationService;
import courseRegistrationSystem.service.impl.RegistrationEventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = { "/registration-events"})
public class RegistrationEventController {

    @Autowired
    RegistrationEventServiceImpl registrationEventService;


    @GetMapping("/latest")
    public ResponseEntity<List<RegistrationEventDTO>> getRegistrationAlls() {
        var allRegistrations = registrationEventService.getAllRegistrationEvents();
        RegistrationEvent event = null;

        return  new ResponseEntity<>(allRegistrations, HttpStatus.OK);
    }

    @GetMapping(value = {"/get/{registrationId}"})
    public ResponseEntity<RegistrationEventDTO> getRegistrationById(@PathVariable Long registrationId) {

        return  new ResponseEntity<>(registrationEventService.getRegistrationEventBy_Id(registrationId),HttpStatus.OK);
    }

    @PostMapping(value = {"/addRegistrationEvent"})
    public ResponseEntity<RegistrationEventDTO> addNewJob(@Valid @RequestBody RegistrationEventDTO registrationEventdto) {
        return new ResponseEntity<>(registrationEventService.addNewRegistrationEvent(registrationEventdto),HttpStatus.OK);
    }
    @DeleteMapping(value = {"/delete/{registrationEventId}"})
    public ResponseEntity<Void> deleteRegistrationById(@PathVariable Long registrationEventId) {
        registrationEventService.deleteById(registrationEventId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

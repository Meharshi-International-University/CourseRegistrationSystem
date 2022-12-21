package courseRegistrationSystem.controller;

import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.dto.RegistrationDTO;
import courseRegistrationSystem.dto.RegistrationEventDTO;
import courseRegistrationSystem.dto.RegistrationEventStudentDTO;
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


    @GetMapping("/")
    public ResponseEntity<List<RegistrationEventDTO>> getRegistrationAlls() {

        return  new ResponseEntity<>( registrationEventService.getAllRegistrationEvents(), HttpStatus.OK);
    }
    @GetMapping(value = {"/latest/{studentId}"})
    public ResponseEntity<?> getRegistrationEventsStudentByIdDec(@PathVariable("studentId") Long studentId) {

        return  new ResponseEntity<>(registrationEventService.findLatestEventByStudentId(studentId),HttpStatus.OK);
    }

    @GetMapping(value = {"/{registrationId}"})
    public ResponseEntity<RegistrationEventDTO> getRegistrationById(@PathVariable("registrationId") Long registrationId) {

        return  new ResponseEntity<>(registrationEventService.getRegistrationEventBy_Id(registrationId),HttpStatus.OK);
    }

    @PostMapping(value = {"/"})
    public ResponseEntity<RegistrationEventDTO> addNewRegistrationEventJob(@Valid @RequestBody RegistrationEventDTO registrationEventdto) {
        return new ResponseEntity<>(registrationEventService.addNewRegistrationEvent(registrationEventdto),HttpStatus.OK);
    }
    @DeleteMapping(value = {"/{registrationEventId}"})
    public ResponseEntity<Void> deleteRegistrationById(@PathVariable Long registrationEventId) {
        registrationEventService.deleteById(registrationEventId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping(value = {"/{registrationId}"})
    public ResponseEntity<RegistrationEventDTO> updateRegistrationEvent(@PathVariable("registrationId") Long registrationId,@Valid @RequestBody RegistrationEventDTO registrationEventdto) {
        return new ResponseEntity<>(registrationEventService
                .updateRegistrationEvent(registrationId,registrationEventdto),HttpStatus.OK);

    }
    @GetMapping(value = {"/student/{studentId}"})
    public ResponseEntity<RegistrationEventStudentDTO> getRegistrationByStudentId(@PathVariable("studentId") Long studentId) {

        return  new ResponseEntity<>(registrationEventService.getRegistrationByStudentId(studentId),HttpStatus.OK);
    }
}

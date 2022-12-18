package courseRegistrationSystem.controller;

import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.domain.Student;
import courseRegistrationSystem.dto.RegistrationDTO;
import courseRegistrationSystem.dto.RegistrationEventDTO;
import courseRegistrationSystem.enums.RegistrationEventStatus;
import courseRegistrationSystem.service.RegistrationService;
import courseRegistrationSystem.service.impl.RegistrationEventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = { "/registration-events"})
public class RegistrationEventController {

    @Autowired
    RegistrationEventServiceImpl registrationEventService;


    @GetMapping("/latest")
    public ResponseEntity<List<RegistrationEventDTO>> getRegistrationAlls() {
        var allRegistrationEvents = registrationEventService.getAllRegistrationEvents();

        return  new ResponseEntity<>(allRegistrationEvents, HttpStatus.OK);
    }
    @GetMapping({"/status/{status}"})
    public ResponseEntity<RegistrationEventDTO> getStatus(@PathVariable RegistrationEventStatus status){
        return new ResponseEntity<>(registrationEventService.registrationStatus(status), HttpStatus.OK);
    }

    @GetMapping(value = {"/get/{registrationId}"})
    public ResponseEntity<RegistrationEventDTO> getRegistrationEventById(@PathVariable Long registrationId) {
       var regById= registrationEventService.getRegistrationEventBy_Id(registrationId);
        return  new ResponseEntity<>(regById,HttpStatus.OK);
    }
//    @GetMapping(value = {"/filter/{group}"})
//    public ResponseEntity<RegistrationEventDTO> filterStudentsByGroup(@PathVariable String group) {
//        RegistrationEvent event= new RegistrationEvent();
//        List<RegistrationEventDTO> filterGroup = null;
//        filterGroup = registrationEventService.getAllRegistrationEvents().stream()
//                .map(m->m.getRegistrationGroupDTOS().stream()
//                .filter(g->g.getStudentDTOS().stream()
//                        .map(s->s.getStudentId().equals(group)).collect(Collectors.toList())));
//
//       // var regById= registrationEventService.getRegistrationEventBy_Id(registrationId);
//        return  new ResponseEntity<>(regById,HttpStatus.OK);
   // }

    @PostMapping(value = {"/addRegistrationEvent"})
    public ResponseEntity<RegistrationEventDTO> addNewRegistrationEvent(@Valid @RequestBody RegistrationEvent registrationEvent) {
        return new ResponseEntity<>(registrationEventService.addNewRegistrationEvent(registrationEvent),HttpStatus.OK);
    }
    @PutMapping(value = {"/updateRegistrationEvent"})
    public ResponseEntity<RegistrationEventDTO> updateRegistrationEvent(@PathVariable Long registrationId,@Valid @RequestBody RegistrationEvent registrationEvent) {
        var regById= registrationEventService.updateRegistrationEvent(registrationId,registrationEvent);
        return new ResponseEntity<>(regById,HttpStatus.OK);
    }
    @DeleteMapping(value = {"/delete/{registrationEventId}"})
    public ResponseEntity<Void> deleteRegistrationById(@PathVariable Long registrationEventId) {
        registrationEventService.deleteById(registrationEventId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

package courseRegistrationSystem.controller;

import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.dto.RegistrationDTO;
import courseRegistrationSystem.dto.RegistrationEventDTO;
import courseRegistrationSystem.exception.CustomErrorType;
import courseRegistrationSystem.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = { "/registrations"})
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;


    @GetMapping(value = {"/list"})
    public ResponseEntity<List<RegistrationDTO>> getAllRegistrations() {
        var allRegistrations = registrationService.getAllRegisters();
        return new ResponseEntity<>(allRegistrations, HttpStatus.OK);
    }

    @GetMapping(value = {"/get/{registrationId}"})
    public ResponseEntity<RegistrationDTO> getRegistrationById(@PathVariable Long registrationId) {
        var checkId= registrationService.getRegistrationBy_Id(registrationId);

        if (checkId == null) {
            new ResponseEntity<CustomErrorType>
                    (new CustomErrorType("Contact with firstname= " + registrationId + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(checkId, HttpStatus.OK);
    }

    @PostMapping(value = {"/addRegistration"})
    public ResponseEntity<RegistrationDTO> addNewRegistration(@Valid @RequestBody Registration registration) {
        return new ResponseEntity<>(registrationService.addNewRegistration(registration), HttpStatus.OK);
    }

    @PutMapping(value = {"/updateRegistration"})
    public ResponseEntity<RegistrationDTO> updateRegistration(@PathVariable Long registrationId, @Valid @RequestBody Registration registration) {
        var regById = registrationService.updateRegistration(registrationId, registration);
        return new ResponseEntity<>(regById, HttpStatus.OK);
    }

    @DeleteMapping(value = {"/delete/{registrationEventId}"})
    public ResponseEntity<?> deleteRegistrationById(@PathVariable Long registrationId) {
        registrationService.deleteById(registrationId);


        if (registrationId == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Contact with firstname= " + registrationId + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
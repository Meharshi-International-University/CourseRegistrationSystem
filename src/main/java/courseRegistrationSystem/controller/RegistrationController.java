package courseRegistrationSystem.controller;

import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.dto.RegistrationDto;
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
    public ResponseEntity<List<RegistrationDto>> getRegistrationAlls() {
        var allJobs = registrationService.getAllRegisters();
        return  new ResponseEntity<>(allJobs, HttpStatus.OK);
    }

    @GetMapping(path = {"/get/{registrationId}"})
    public ResponseEntity<RegistrationDto> getRegistrationById(@PathVariable Long registrationId) {
        return  new ResponseEntity<>(registrationService.getRegistrationBy_Id(registrationId),HttpStatus.OK);
    }

    @PostMapping(value = {"/addRegistration"})
    public ResponseEntity<Registration> addNewJob( @Valid @RequestBody RegistrationDto registrationdto) {
        return new ResponseEntity<>(registrationService.addNewRegistration(registrationdto),HttpStatus.OK);
    }

}

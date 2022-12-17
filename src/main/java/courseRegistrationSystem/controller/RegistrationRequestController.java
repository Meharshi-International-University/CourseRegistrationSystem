package courseRegistrationSystem.controller;

import courseRegistrationSystem.domain.RegistrationRequest;
import courseRegistrationSystem.dto.RegistrationRequestDto;
import courseRegistrationSystem.service.RegistrationRequestService;
import courseRegistrationSystem.service.impl.RegistrationRequestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration-requests/")
@Slf4j
public class RegistrationRequestController {

    @Autowired
    private RegistrationRequestService registrationRequestService;


    @PostMapping()
    public ResponseEntity<?> saveRegistrationRequest(@RequestBody RegistrationRequestDto registrationRequest){
    log.info("Inside saveRegistrationRequest method of RegistrationRequestController");
        registrationRequestService.saveRegistrationRequest(registrationRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateRegistrationRequest(@PathVariable("id") Long id,@RequestBody RegistrationRequestDto registrationRequest){
        log.info("Inside updateRegistrationRequest method of RegistrationRequestController");
        registrationRequestService.updateRegistrationRequest(id,registrationRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteRegistrationRequest(@PathVariable("id") Long id){
        log.info("Inside deleteRegistrationRequest method of RegistrationRequestController");
        registrationRequestService.deleteRegistrationRequest(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @GetMapping("{id}")
    public ResponseEntity<?> getRegistrationRequest(@PathVariable("id") Long id){
        log.info("Inside getRegistrationRequest method of RegistrationRequestController");
        registrationRequestService.getRegistrationRequest(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }






}

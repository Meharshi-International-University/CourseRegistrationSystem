package courseRegistrationSystem.controller;

import courseRegistrationSystem.dto.RegistrationRequestDTO;
import courseRegistrationSystem.service.RegistrationRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<?> saveRegistrationRequest(@RequestBody RegistrationRequestDTO registrationRequest){
        log.info("Inside saveRegistrationRequest method of RegistrationRequestController");
        try {
            registrationRequestService.saveRegistrationRequest(registrationRequest);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateRegistrationRequest(@PathVariable("id") Long id,@RequestBody RegistrationRequestDTO registrationRequest){
        log.info("Inside updateRegistrationRequest method of RegistrationRequestController");

        try {
            registrationRequestService.updateRegistrationRequest(id,registrationRequest);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteRegistrationRequest(@PathVariable("id") Long id){
        log.info("Inside deleteRegistrationRequest method of RegistrationRequestController");
        registrationRequestService.deleteRegistrationRequest(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("{id}")
    public ResponseEntity<?> getRegistrationRequest(@PathVariable("id") Long id){
        log.info("Inside getRegistrationRequest method of RegistrationRequestController");
        return  ResponseEntity.ok().body( registrationRequestService.getRegistrationRequest(id));

    }






}
package courseRegistrationSystem.controller;

import courseRegistrationSystem.dto.RegistrationRequestDTO;
import courseRegistrationSystem.dto.RegistrationRequestListDTO;
import courseRegistrationSystem.service.RegistrationRequestService;
import courseRegistrationSystem.validation.RegistrationRequestListValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/registration-requests/")
@Slf4j
public class RegistrationRequestController {

    @Autowired
    private RegistrationRequestService registrationRequestService;

    @Autowired
    private RegistrationRequestListValidator registrationRequestListValidator;

    @InitBinder("registrationRequestListDTO")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(registrationRequestListValidator);

    }

    @PostMapping
    public ResponseEntity<?> saveRegistrationRequests(@Validated @RequestBody RegistrationRequestListDTO registrationRequestListDTO){
        log.info("Inside saveRegistrationRequests method of RegistrationRequestController");
        try {
            registrationRequestService.saveRegistrationRequests(registrationRequestListDTO.getStudentId(),registrationRequestListDTO);
        }catch (Exception e){
            return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @GetMapping("{id}")
    public ResponseEntity<?> getRegistrationRequest(@PathVariable("id") Long id){
        log.info("Inside getRegistrationRequest method of RegistrationRequestController");
        return  ResponseEntity.ok().body( registrationRequestService.getRegistrationRequest(id));

    }

    @GetMapping("by-student/{studentId}")
    public ResponseEntity<?> getRegistrationRequestByStudent(@PathVariable("studentId") Long studentId){
        log.info("Inside getRegistrationRequestByStudent method of RegistrationRequestController");
        return  ResponseEntity.ok().body( registrationRequestService.getRegistrationRequestByStudent(studentId));

    }


}
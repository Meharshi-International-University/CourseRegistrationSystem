package courseRegistrationSystem.controller;

import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.dto.RegistrationDTO;
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


    @GetMapping(value = {"/{studentId}"})
    public ResponseEntity<?> getAllRegistrationByStudentId(@PathVariable("studentId") Long studentId) {

        return  new ResponseEntity<>(registrationService.getAllCourseOfferingByStudentId(studentId), HttpStatus.OK);
    }

    @GetMapping(value = {"/get/{registrationId}"})
    public ResponseEntity<RegistrationDTO> getRegistrationById(@PathVariable Long registrationId) {

        return  new ResponseEntity<>(registrationService.getRegistrationBy_Id(registrationId),HttpStatus.OK);
    }
//
//    @PostMapping(value = {"/addRegistration"})
//    public ResponseEntity<Registration> addNewJob( @Valid @RequestBody RegistrationDTO registrationdto) {
//        return new ResponseEntity<>(registrationService.addNewRegistration(registrationdto),HttpStatus.OK);
//    }
//    @DeleteMapping(value = {"/delete/{registrationId}"})
//    public ResponseEntity<Void> deleteRegistrationById(@PathVariable Long registrationId) {
//       Registration registration= registrationService.deleteById(registrationId);
//        return  new ResponseEntity<>(,HttpStatus.NO_CONTENT);
//    }

    @GetMapping(value = {"/list"})
    public ResponseEntity<List<RegistrationDTO>> getRegistrationAlls() {
        var allRegistrations = registrationService.getAllRegisters();
        return  new ResponseEntity<>(allRegistrations, HttpStatus.OK);
    }

}

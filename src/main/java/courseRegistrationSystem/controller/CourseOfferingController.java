package courseRegistrationSystem.controller;

import courseRegistrationSystem.domain.CourseOffering;
import courseRegistrationSystem.domain.Faculty;
import courseRegistrationSystem.dto.CourseOfferingDTO;
import courseRegistrationSystem.dto.FacultyDTO;
import courseRegistrationSystem.exception.CustomErrorType;
import courseRegistrationSystem.service.CourseOfferingService;
import courseRegistrationSystem.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = { "/courseOfferings"})
public class CourseOfferingController {

    @Autowired
    private CourseOfferingService courseOfferingService;


    @GetMapping(value = {"/list"})
    public ResponseEntity<List<CourseOfferingDTO>> getRegistrationAlls() {
        var allCourseOffering = courseOfferingService.getAllCourseOfferings();
        return new ResponseEntity<>(allCourseOffering, HttpStatus.OK);
    }

    @GetMapping(value = {"/get/{offeringId}"})
    public ResponseEntity<CourseOfferingDTO> getCourseOfferingyId(@PathVariable Long offeringId) {
        var checkId= courseOfferingService.getCourseOfferingBy_Id(offeringId);

        if (checkId == null) {
            new ResponseEntity<CustomErrorType>
                    (new CustomErrorType("Contact with firstname= " + offeringId + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(checkId, HttpStatus.OK);
    }

    @PostMapping(value = {"/addRegistration"})
    public ResponseEntity<CourseOfferingDTO> addNewCourseOffering(@Valid @RequestBody CourseOffering courseOffering) {
        return new ResponseEntity<>( courseOfferingService.addNewCourseOffering(courseOffering), HttpStatus.OK);
    }

//    @PutMapping(value = {"/updateRegistration"})
//    public ResponseEntity<RegistrationDTO> updateRegistration(@PathVariable Long registrationId, @Valid @RequestBody Registration registration) {
//        var regById = registrationService.updateRegistration(registrationId, registration);
//        return new ResponseEntity<>(regById, HttpStatus.OK);
//    }
//
//    @DeleteMapping(value = {"/delete/{registrationEventId}"})
//    public ResponseEntity<?> deleteRegistrationById(@PathVariable Long registrationId) {
//        registrationService.deleteById(registrationId);
//
//
//        if (registrationId == null) {
//            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Contact with firstname= " + registrationId + " is not available"), HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
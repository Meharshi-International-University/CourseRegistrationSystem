package courseRegistrationSystem.controller;

import courseRegistrationSystem.domain.Faculty;
import courseRegistrationSystem.domain.Student;
import courseRegistrationSystem.dto.FacultyDTO;
import courseRegistrationSystem.dto.StudentDTO;
import courseRegistrationSystem.exception.CustomErrorType;
import courseRegistrationSystem.service.FacultyService;
import courseRegistrationSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = { "/faculties"})
public class FacultyController {

    @Autowired
    private FacultyService facultyService;


    @GetMapping(value = {"/list"})
    public ResponseEntity<List<FacultyDTO>> getAllFaculties() {
        var allFaculties = facultyService.getAllFaculties();
        return new ResponseEntity<>(allFaculties, HttpStatus.OK);
    }

    @GetMapping(value = {"/get/{facultyId}"})
    public ResponseEntity<FacultyDTO> getFacultiesById(@PathVariable Long facultyId) {
        var checkId= facultyService.getFacultyBy_Id(facultyId);

        if (checkId == null) {
            new ResponseEntity<CustomErrorType>
                    (new CustomErrorType("Contact with firstname= " + facultyId + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(checkId, HttpStatus.OK);
    }

    @PostMapping(value = {"/addFaculty"})
    public ResponseEntity<FacultyDTO> addNewFaculties(@Valid @RequestBody Faculty faculty) {
        return new ResponseEntity<>(facultyService.addNewFaculty(faculty), HttpStatus.OK);
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
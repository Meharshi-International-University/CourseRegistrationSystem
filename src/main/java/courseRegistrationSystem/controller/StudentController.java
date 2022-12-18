package courseRegistrationSystem.controller;

import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.domain.Student;
import courseRegistrationSystem.dto.RegistrationDTO;
import courseRegistrationSystem.dto.StudentDTO;
import courseRegistrationSystem.exception.CustomErrorType;
import courseRegistrationSystem.service.RegistrationService;
import courseRegistrationSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = { "/students"})
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping(value = {"/list"})
    public ResponseEntity<List<StudentDTO>> getRegistrationAlls() {
        var allStudents = studentService.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @GetMapping(value = {"/get/{studentId}"})
    public ResponseEntity<StudentDTO> getRegistrationById(@PathVariable Long studentId) {
        var checkId= studentService.getStudentBy_Id(studentId);

        if (checkId == null) {
            new ResponseEntity<CustomErrorType>
                    (new CustomErrorType("Contact with firstname= " + studentId + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(checkId, HttpStatus.OK);
    }

    @PostMapping(value = {"/addStudent"})
    public ResponseEntity<StudentDTO> addNewRegistration(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(studentService.addNewStudent(student), HttpStatus.OK);
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
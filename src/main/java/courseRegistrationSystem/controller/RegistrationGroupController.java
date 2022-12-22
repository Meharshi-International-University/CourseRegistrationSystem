package courseRegistrationSystem.controller;

import courseRegistrationSystem.domain.Faculty;
import courseRegistrationSystem.domain.RegistrationGroup;
import courseRegistrationSystem.dto.FacultyDTO;
import courseRegistrationSystem.dto.RegistrationGroupDTO;
import courseRegistrationSystem.exception.CustomErrorType;
import courseRegistrationSystem.service.FacultyService;
import courseRegistrationSystem.service.RegistrationGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = { "/registration-groups"})
public class RegistrationGroupController {

    @Autowired
    private RegistrationGroupService groupService;

    @GetMapping(value = {"/list"})
    public ResponseEntity<List<RegistrationGroupDTO>> getAllRegistrationGroups() {
        var allGroups = groupService.getAllRegistrationGroups();
        return new ResponseEntity<>(allGroups, HttpStatus.OK);
    }

    @GetMapping(value = {"/get/{groupId}"})
    public ResponseEntity<RegistrationGroupDTO> getRegistrationGroupById(@PathVariable Long groupId) {
        var checkId= groupService.getRegistrationGroupBy_Id(groupId);

        if (checkId == null) {
            new ResponseEntity<CustomErrorType>
                    (new CustomErrorType("Contact with firstname= " + groupId + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(checkId, HttpStatus.OK);
    }

    @PostMapping(value = {"/addRegistrationGroup"})
    public ResponseEntity<RegistrationGroupDTO> addNewRegistrationGroup(@Valid @RequestBody RegistrationGroup group) {
        return new ResponseEntity<>(groupService.addNewRegistrationGroup(group), HttpStatus.OK);
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
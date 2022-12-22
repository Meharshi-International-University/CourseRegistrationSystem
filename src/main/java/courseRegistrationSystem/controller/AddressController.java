package courseRegistrationSystem.controller;

import courseRegistrationSystem.domain.Address;
import courseRegistrationSystem.domain.Student;
import courseRegistrationSystem.dto.AddressDTO;
import courseRegistrationSystem.dto.StudentDTO;
import courseRegistrationSystem.exception.CustomErrorType;
import courseRegistrationSystem.service.AddressService;
import courseRegistrationSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

///@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = { "/address"})
public class AddressController {

    @Autowired
    private AddressService addressService;


    @GetMapping(value = {"/list"})
    public ResponseEntity<List<AddressDTO>> getAllAddress() {
        return new ResponseEntity<>(addressService.getAllAddress(), HttpStatus.OK);
    }

    @GetMapping(value = {"/get/{addressId}"})
    public ResponseEntity<AddressDTO> getRegistrationById(@PathVariable Long addressId) {
        var checkId= addressService.getAddressBy_Id(addressId);

        if (checkId == null) {
            new ResponseEntity<CustomErrorType>
                    (new CustomErrorType("Contact with firstname= " + addressId + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(checkId, HttpStatus.OK);
    }

    @PostMapping(value = {"/addAddress"})
    public ResponseEntity<AddressDTO> addNewRegistration(@Valid @RequestBody Address address) {
        return new ResponseEntity<>(addressService.addNewAddress(address), HttpStatus.OK);
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
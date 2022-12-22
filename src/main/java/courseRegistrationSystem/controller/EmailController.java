package courseRegistrationSystem.controller;

import courseRegistrationSystem.domain.AcademicBlock;
import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.dto.AcademicBlockDTO;
import courseRegistrationSystem.dto.RegistrationEventDTO;
import courseRegistrationSystem.dto.RegistrationGroupDTO;
import courseRegistrationSystem.dto.StudentDTO;
import courseRegistrationSystem.service.RegistrationEventService;
import courseRegistrationSystem.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/email-list/")
@Slf4j
public class EmailController {

    @Autowired
    private RegistrationEventService registrationEventServiceService;

    @GetMapping("{registrationEventId}")
    public ResponseEntity<?> registrationEventDetailsById(@PathVariable("registrationEventId") Long registrationEventId) {
        log.info("inside registrationEventDetailsById method of  EmailController");
        RegistrationEventDTO registrationEventDTO = registrationEventServiceService.getRegistrationEventBy_Id(registrationEventId);
        return new ResponseEntity<>(registrationEventDTO, HttpStatus.OK);

    }
}

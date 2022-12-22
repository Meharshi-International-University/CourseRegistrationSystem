package courseRegistrationSystem.controller;

import courseRegistrationSystem.service.ProcessRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration-events/")
@Slf4j
public class ProcessRegistrationController {


    @Autowired
    private ProcessRegistrationService processRegistrationService;

    @PatchMapping("{id}")
    public ResponseEntity<?> processRegistration(@PathVariable("id") Long id, @RequestParam("processed") boolean processed) {
        log.info("Inside processRegistration method of ProcessRegistrationController");
        if (processed)
            processRegistrationService.processRegistration(id);
        return new ResponseEntity<>("Process Completed",HttpStatus.OK);
    }
}

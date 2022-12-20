package courseRegistrationSystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration-events/")
@Slf4j
public class ProcessRegistrationController {

    @PatchMapping("{id}")
    public ResponseEntity<?> processRegistration(@PathVariable("id") Long id,@RequestParam("processed") boolean processed){
        log.info("Inside processRegistration method of ProcessRegistrationController");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

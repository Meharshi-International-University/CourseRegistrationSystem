package courseRegistrationSystem.controller;

import courseRegistrationSystem.domain.AcademicBlock;
import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.dto.AcademicBlockDTO;
import courseRegistrationSystem.dto.RegistrationEventDTO;
import courseRegistrationSystem.dto.RegistrationGroupDTO;
import courseRegistrationSystem.dto.StudentDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
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

    @GetMapping("{registrationEventId}")
    public ResponseEntity<?> registrationEventDetailsById(@PathVariable("registrationEventId") Long registrationEventId){
        log.info("inside registrationEventDetailsById method of  EmailController");
        //TODO
        //Get from Repo
        RegistrationEventDTO registrationEvent = new RegistrationEventDTO();
        registrationEvent.setStartDate(LocalDateTime.now());
        registrationEvent.setEndDate(LocalDateTime.now());
        List<StudentDTO> studentDTOList1 = new ArrayList<>();
        List<StudentDTO> studentDTOList2 = new ArrayList<>();
        StudentDTO st1 = new StudentDTO("Srijana Lama","srijana.lama@miu.edu");
        StudentDTO st2 = new StudentDTO("Srna Lama","srijanalama94@gmail.com");
        studentDTOList1.add(st1);
        studentDTOList1.add(st2);
        studentDTOList2.add(st1);
        studentDTOList2.add(st2);

        AcademicBlockDTO ac = new AcademicBlockDTO("CS222","abc",LocalDateTime.now(),LocalDateTime.now());
        List<AcademicBlockDTO> academicBlockDTOList = new ArrayList<>();
        academicBlockDTOList.add(ac);

        List<RegistrationGroupDTO> rgGroup1 = new ArrayList<>();
        rgGroup1.add(new RegistrationGroupDTO(studentDTOList1,academicBlockDTOList));
        rgGroup1.add(new RegistrationGroupDTO(studentDTOList2,academicBlockDTOList));

        registrationEvent.setRegistrationGroups(rgGroup1);
        return new ResponseEntity<>(registrationEvent, HttpStatus.OK);

    }
}

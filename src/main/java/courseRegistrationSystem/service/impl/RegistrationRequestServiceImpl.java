package courseRegistrationSystem.service.impl;

import courseRegistrationSystem.domain.CourseOffering;
import courseRegistrationSystem.domain.RegistrationRequest;
import courseRegistrationSystem.domain.Student;
import courseRegistrationSystem.dto.RegistrationRequestDto;
import courseRegistrationSystem.repository.RegistrationRequestRepository;
import courseRegistrationSystem.service.RegistrationRequestService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@Slf4j
public class RegistrationRequestServiceImpl implements RegistrationRequestService {

    @Autowired
    private RegistrationRequestRepository registrationRequestRepository;


    @Override
    public void saveRegistrationRequest(RegistrationRequestDto registrationRequestDto) {
    log.info("Inside  saveRegistrationRequest method of RegistrationServiceImpl");
    //TOD0
        //GET FROM DB
        Student oStudent = new Student("1","Srijana","srijana.lama@miu.edu");
        CourseOffering oCourseOffering = new CourseOffering();
        RegistrationRequest registrationRequest = new RegistrationRequest(registrationRequestDto.getPriorityNumber(),oStudent,oCourseOffering);
        registrationRequestRepository.save(registrationRequest);
    }

    @Override
    public RegistrationRequest updateRegistrationRequest(Long id,RegistrationRequestDto registrationRequestDto)  {
        log.info("Inside  updateRegistrationRequest method of RegistrationServiceImpl");
        //TOD0
        //GET FROM DB
        Student oStudent = new Student("1","Srijana","srijana.lama@miu.edu");
        CourseOffering oCourseOffering = new CourseOffering();

        RegistrationRequest oRegistrationRequest = registrationRequestRepository.findById(id).orElseThrow(() ->
          new RuntimeException("Registration Request Not Found "));

        registrationRequestRepository.save(oRegistrationRequest);
        return null;
    }

    @Override
    public void deleteRegistrationRequest(Long id) {
        log.info("Inside  deleteRegistrationRequest method of RegistrationServiceImpl");
        registrationRequestRepository.deleteById(id);
    }

    @Override
    public RegistrationRequest getRegistrationRequest(Long id) {
        log.info("Inside  getRegistrationRequest method of RegistrationServiceImpl");
        return registrationRequestRepository.findById(id).orElseThrow(()->new RuntimeException("Registration Request Not Found"));
    }


}

package courseRegistrationSystem.service.impl;

import courseRegistrationSystem.domain.CourseOffering;
import courseRegistrationSystem.domain.RegistrationRequest;
import courseRegistrationSystem.domain.Student;
import courseRegistrationSystem.dto.RegistrationRequestDTO;
import courseRegistrationSystem.repository.CourseOfferingRepository;
import courseRegistrationSystem.repository.RegistrationRequestRepository;
import courseRegistrationSystem.repository.StudentRepository;
import courseRegistrationSystem.service.RegistrationRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegistrationRequestServiceImpl implements RegistrationRequestService {

    @Autowired
    private RegistrationRequestRepository registrationRequestRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseOfferingRepository courseOfferingRepository;


    @Override
    public void saveRegistrationRequest(RegistrationRequestDTO registrationRequestDto) {
    log.info("Inside  saveRegistrationRequest method of RegistrationServiceImpl");

        Student oStudent = studentRepository.findByStudentId(registrationRequestDto.getStudentId());
        CourseOffering oCourseOffering = courseOfferingRepository.findByCourseOfferingCode(registrationRequestDto.getCourseOfferingCode());
        RegistrationRequest registrationRequest = new RegistrationRequest(registrationRequestDto.getPriorityNumber(),oStudent,oCourseOffering);
        registrationRequestRepository.save(registrationRequest);
    }

    @Override
    public void updateRegistrationRequest(Long id,RegistrationRequestDTO registrationRequestDto)  {
        log.info("Inside  updateRegistrationRequest method of RegistrationServiceImpl");

        Student oStudent = studentRepository.findByStudentId(registrationRequestDto.getStudentId());
        CourseOffering oCourseOffering = courseOfferingRepository.findByCourseOfferingCode(registrationRequestDto.getCourseOfferingCode());


        RegistrationRequest oRegistrationRequest = registrationRequestRepository.findById(id).orElseThrow(() ->
          new RuntimeException("Registration Request Not Found "));

        registrationRequestRepository.save(oRegistrationRequest);

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

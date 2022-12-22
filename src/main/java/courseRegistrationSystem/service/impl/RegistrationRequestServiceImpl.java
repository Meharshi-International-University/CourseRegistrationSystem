package courseRegistrationSystem.service.impl;

import courseRegistrationSystem.domain.CourseOffering;
import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.domain.RegistrationRequest;
import courseRegistrationSystem.domain.Student;
import courseRegistrationSystem.dto.RegistrationRequestDTO;
import courseRegistrationSystem.dto.RegistrationRequestListDTO;
import courseRegistrationSystem.repository.CourseOfferingRepository;
import courseRegistrationSystem.repository.RegistrationEventRepository;
import courseRegistrationSystem.repository.RegistrationRequestRepository;
import courseRegistrationSystem.repository.StudentRepository;
import courseRegistrationSystem.service.RegistrationRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class RegistrationRequestServiceImpl implements RegistrationRequestService {

    @Autowired
    private RegistrationRequestRepository registrationRequestRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseOfferingRepository courseOfferingRepository;


    @Autowired
    private RegistrationEventRepository registrationEventRepository;
    @Override
    public void saveRegistrationRequests(Long studentId, RegistrationRequestListDTO registrationRequestDtos) {
        log.info("Inside  saveRegistrationRequests method of RegistrationServiceImpl");

        Student oStudent = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Student  Not Found"));
        RegistrationEvent oRegistrationEvent = registrationEventRepository.findById(registrationRequestDtos.getRegistrationEventId()).orElseThrow(()->new RuntimeException("Event Not Found"));
        List<RegistrationRequest> registrationRequestList=   registrationRequestDtos.getRegistrationRequestDTOList().stream().map(registrationRequestDTO -> {
            CourseOffering oCourseOffering = courseOfferingRepository.findByCourseOfferingCode(registrationRequestDTO.getCourseOfferringCode()).orElseThrow(()-> new RuntimeException("Course Offering Not Found"));
            return new RegistrationRequest(registrationRequestDTO.getPriorityNumber(),oStudent,oCourseOffering,oRegistrationEvent);
        }).collect(Collectors.toList());
        registrationRequestRepository.saveAll(registrationRequestList);
    }



    @Override
    public RegistrationRequest getRegistrationRequest(Long id) {
        return null;
    }


    @Override
    public List<RegistrationRequest> getRegistrationRequestByStudent(Long studentId) {
        log.info("Inside  getRegistrationRequestByStudent method of RegistrationServiceImpl");
        return registrationRequestRepository.findByStudentId(studentId);
    }


}
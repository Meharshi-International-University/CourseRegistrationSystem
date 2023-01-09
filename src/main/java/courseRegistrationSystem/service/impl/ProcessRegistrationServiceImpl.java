package courseRegistrationSystem.service.impl;

import courseRegistrationSystem.domain.*;
import courseRegistrationSystem.domain.pk.RegistrationRequestPK;
import courseRegistrationSystem.enums.RegistrationEventStatus;
import courseRegistrationSystem.enums.RegistrationRequestStatus;
import courseRegistrationSystem.repository.*;
import courseRegistrationSystem.service.ProcessRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@Transactional
@Slf4j
public class ProcessRegistrationServiceImpl implements ProcessRegistrationService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RegistrationRequestRepository registrationRequestRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private AcademicBlockRepository academicBlockRepository;


    @Autowired
    private CourseOfferingRepository courseOfferingRepository;

    @Autowired
    private  RegistrationEventRepository registrationEventRepository;

    @Override
    public void processRegistration(Long id) {
        log.info("inside processRegistration method of ProcessRegistrationServiceImpl");
        registrationEventRepository.findById(id).orElseThrow(()-> new RuntimeException("Event Found Not Found")).setRegistrationEventStatus(RegistrationEventStatus.CLOSED);
        List<RegistrationRequest> requestList = registrationRequestRepository.
                findRegistrationRequestByRegistrationEventIdAndStatus(id, RegistrationRequestStatus.ONGOING);

        while (requestList.size() > 0) {
            RegistrationRequest selectedValue = requestList.get(
                    Math.abs(new Random().nextInt(requestList.size())));
            RegistrationRequest registrationRequest = registrationRequestRepository.
                    findByIdEager(selectedValue.getStudent().getId(),selectedValue.getCourseOffering().getId());
            if (checkPrequisiteIsMet(registrationRequest.getCourseOffering().getId()) && checkAvailableSeats(registrationRequest.getCourseOffering())) {
                registrationRepository.save(new Registration(registrationRequest.getStudent(), registrationRequest.getCourseOffering()));
                registrationRequest.setStatus(RegistrationRequestStatus.COMPLETE);

                List<CourseOffering> courseOfferingListByBlock = courseOfferingRepository.
                        findByAcademicBlock_Id(registrationRequest.getCourseOffering().getAcademicBlock().getId());

                courseOfferingListByBlock.forEach(courseOffering -> {
                    registrationRequestRepository.findById(new RegistrationRequestPK(registrationRequest.getStudent(), courseOffering))
                            .ifPresentOrElse(registrationRequest1
                                            -> {
                                        if (registrationRequest1.getStatus() != RegistrationRequestStatus.COMPLETE)
                                            registrationRequest1.setStatus(RegistrationRequestStatus.INVALID);
                                    },
                                    ()
                                            -> {
                                        throw new RuntimeException("Not found");
                                    });


                });

            } else {
                registrationRequest.setStatus(RegistrationRequestStatus.INVALID);
            }
            requestList = registrationRequestRepository.
                    findRegistrationRequestByRegistrationEventIdAndStatus(id, RegistrationRequestStatus.ONGOING);

        }
    }

    public boolean checkAvailableSeats(CourseOffering courseOffering) {
        log.info("inside checkAvailableSeats method of ProcessRegistrationServiceImpl");
        if (courseOffering.getAvailableSeats() > 0) {
            courseOffering.setAvailableSeats(courseOffering.getAvailableSeats() - 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPrequisiteIsMet(Long courseOfferingCode) {
        log.info("inside checkPrequisiteIsMet method of ProcessRegistrationServiceImpl");
        List<Course> prequisiteCourseList = registrationRequestRepository.findPrequisiteByCourseOfferingId(courseOfferingCode);
        if (prequisiteCourseList.size() == 0) return true;
        for (Course course : prequisiteCourseList) {
            Course course1 = registrationRepository.findCourseByCourseOfferingId(course.getId());
            if (course1 != null) return true;
        }
        return false;
    }
}

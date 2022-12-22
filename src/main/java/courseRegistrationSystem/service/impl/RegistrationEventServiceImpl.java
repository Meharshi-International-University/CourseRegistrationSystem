package courseRegistrationSystem.service.impl;

import courseRegistrationSystem.domain.CourseOffering;
import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.domain.RegistrationGroup;
import courseRegistrationSystem.dto.CourseOfferingDTO;
import courseRegistrationSystem.dto.RegistrationDTO;
import courseRegistrationSystem.dto.RegistrationEventDTO;
import courseRegistrationSystem.dto.RegistrationEventStudentDTO;
import courseRegistrationSystem.enums.RegistrationRequestStatus;
import courseRegistrationSystem.repository.CourseOfferingRepository;
import courseRegistrationSystem.repository.RegistrationEventRepository;
import courseRegistrationSystem.repository.RegistrationGroupRepository;
import courseRegistrationSystem.repository.RegistrationRepository;
import courseRegistrationSystem.service.RegistrationEventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RegistrationEventServiceImpl implements RegistrationEventService {
    @Autowired
   private RegistrationEventRepository registrationEventRepository;

   @Autowired
  private CourseOfferingRepository courseOfferingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RegistrationGroupRepository registrationGroupRepository;


    @Autowired
    private RegistrationRepository registrationRepository;
    @Override
    public List<RegistrationEventDTO> getAllRegistrationEvents() {
        return registrationEventRepository.findAll().stream()
                .map(registrationEvent -> modelMapper.map(registrationEvent, RegistrationEventDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RegistrationEventDTO findLatestEventByStudentId(Long studentId) {
        return modelMapper.map(registrationEventRepository.getStudentIdByRegistrationEvent(studentId),RegistrationEventDTO.class);
    }

    @Override
    public RegistrationEventStudentDTO getRegistrationByStudentId(Long studentId) {

        RegistrationEventStudentDTO registrationEventStudentDTO= modelMapper.map(registrationEventRepository

                .getStudentIdByRegistrationEvent(studentId),RegistrationEventStudentDTO.class);

        registrationEventStudentDTO.getRegistrationGroups().stream().map(registrationGroupAcademicDTO -> {
            registrationGroupAcademicDTO.getAcademicBlocks().stream().map(academicBlockDTO -> {
//              List<CourseOfferingDTO> courseOfferingDTOList = courseOfferingRepository.findByAcademicBlock_Id(academicBlockDTO.getId()).stream()
//                        .map(courseOffering -> modelMapper.map(courseOffering,CourseOfferingDTO.class)).collect(Collectors.toList());

          academicBlockDTO.setCourseOfferings(courseOfferingRepository.findByAcademicBlock_Id(academicBlockDTO.getId()).stream()
                        .map(courseOffering ->
                        {
                           CourseOfferingDTO courseOfferingDTO = modelMapper.map(courseOffering,CourseOfferingDTO.class);
                           registrationRepository.findByCourseOfferingAndStudent(courseOffering.getId(),studentId)
                                   .ifPresentOrElse(courseOffering1
                                                   -> {
                                               courseOfferingDTO.setSelected(true);
                                           },
                                           ()
                                                   -> {
                                               courseOfferingDTO.setSelected(false);
                                           });;
                           return courseOfferingDTO;
                        })
                  .collect(Collectors.toList()));

                return academicBlockDTO;
            }).collect(Collectors.toList());
            return  registrationGroupAcademicDTO;
        }).collect(Collectors.toList());
        return  registrationEventStudentDTO;

    }

    @Override
    public RegistrationEventDTO getRegistrationEventBy_Id(Long registrationEventId) {
        return modelMapper.map(registrationEventRepository.findById(registrationEventId).orElseThrow( ()->new RuntimeException("No registrationFound"))
                ,RegistrationEventDTO.class);
    }

    @Override
    public RegistrationEventDTO addNewRegistrationEvent(RegistrationEventDTO registrationEventDTO) {

        RegistrationEvent registrationEvent =modelMapper.map(registrationEventDTO, RegistrationEvent.class);
        registrationEvent.setRegistrationGroups(registrationEventDTO
                .getRegistrationGroups().stream()
                .map(r->{
                    return registrationGroupRepository.findByName(r.getName())
                            .orElseThrow(()->new RuntimeException("RegistrationGroup not found"));

                }).collect(Collectors.toList()));
        registrationEventRepository.save(registrationEvent);
        return registrationEventDTO;
    }


    @Override
    public RegistrationEventDTO updateRegistrationEvent(Long registrationId, RegistrationEventDTO registrationEventDTO) {
        var updateRegEvent= registrationEventRepository.findById(registrationId).orElseThrow(()-> new RuntimeException("Evant Not Found"));
        updateRegEvent.setStartDate(registrationEventDTO.getStartDate());
        updateRegEvent.setEndDate(registrationEventDTO.getEndDate());
      updateRegEvent.setRegistrationEventStatus(registrationEventDTO.getRegistrationEventStatus());
      updateRegEvent.setRegistrationGroups(registrationEventDTO.getRegistrationGroups()
                               .stream().map(m->modelMapper.map(m,RegistrationGroup.class)).collect(Collectors.toList()));
        //registrationEventRepository.save(updateRegEvent);

           return registrationEventDTO;
    }


    @Override
    public void deleteById(Long registrationEventId) {
registrationEventRepository.deleteById(registrationEventId);
    }




}

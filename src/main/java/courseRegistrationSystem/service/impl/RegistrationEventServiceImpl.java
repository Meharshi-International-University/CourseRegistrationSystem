package courseRegistrationSystem.service.impl;

import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.domain.RegistrationGroup;
import courseRegistrationSystem.dto.AcademicBlockDTO;
import courseRegistrationSystem.dto.RegistrationEventDTO;
import courseRegistrationSystem.dto.RegistrationGroupDTO;
//import courseRegistrationSystem.enums.RegistrationEventStatus;
import courseRegistrationSystem.repository.AcademicBlockRepository;
import courseRegistrationSystem.repository.RegistrationEventRepository;
import courseRegistrationSystem.repository.RegistrationGroupRepository;
import courseRegistrationSystem.repository.StudentRepository;
import courseRegistrationSystem.service.RegistrationEventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//import static courseRegistrationSystem.enums.RegistrationEventStatus.*;

@Service
@Transactional
public class RegistrationEventServiceImpl implements RegistrationEventService {
    @Autowired
    private RegistrationEventRepository registrationEventRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RegistrationGroupRepository groupRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AcademicBlockRepository academicBlockRepository;

    @Override
    public RegistrationEvent findAllByEndDateDescOrder(Long id) {


        return  null;
    }

    //    private RegistrationEventStatus status;
    @Override
    public List<RegistrationEventDTO> getAllRegistrationEvents() {
        return registrationEventRepository.findAll().stream()
                .map(registrationEvent -> modelMapper.map(registrationEvent, RegistrationEventDTO.class))
                .collect(Collectors.toList());



    }
//    @Override
//    public RegistrationEventDTO registrationStatus(RegistrationEventStatus status ) {
//        LocalDateTime dateTime= LocalDateTime.now();
//        RegistrationEventDTO eventDTO= new RegistrationEventDTO();
//        if (dateTime.isBefore(eventDTO.getEndDate())&& dateTime.isAfter(eventDTO.getStartDate())){
//          status= OPEN;
//        } else if (dateTime.equals(eventDTO.getEndDate())) {
//            status= CLOSED;
//        }else{
//            status= PROGRESS;
//        }
//        return eventDTO;
//    }

//    @Override
//    public List<RegistrationEvent> getRegistrationEventsByStudentId(Long studentId) {
//        var stdId= studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Student Not Found"));
//        return  registrationEventRepository.findByRegistrationGroupsRegistrationGroupId(Long.valueOf(1));
//
//
//    }
//@Override
//public RegistrationEventDTO getRegistrationEventsByStudentId(Long studentId) {
//    var groupId= studentRepository.getRegistrationByStudentId(studentId);//.orElseThrow(()->new RuntimeException("Student Not Found"));
//    List<AcademicBlockDTO> academicBlockDTOS= academicBlockRepository.findByRegistrationGroupId(groupId).stream()
//            .map(x->modelMapper.map(x,AcademicBlockDTO.class)).collect(Collectors.toList());//.forEach(System.out::println);
//     var eventDTO= new RegistrationEventDTO();
//     eventDTO.setRegistrationGroupDTO(modelMapper.map(groupRepository.findById(groupId).get(), RegistrationGroupDTO.class));
//     eventDTO.getRegistrationGroupDTO().setAcademicBlocks(academicBlockDTOS);
//    //return  modelMapper.map(registrationEventRepository.findByRegistrationGroupsRegistrationGroupId(groupId),RegistrationEventDTO.class);
//
//   return eventDTO;
//}


    @Override
    public RegistrationEventDTO getRegistrationEventBy_Id(Long registrationEventId) {
        return modelMapper.map(registrationEventRepository.findById(registrationEventId),RegistrationEventDTO.class);
    }

//    @Override
//    public RegistrationEvent getRegistrationEventStudentId(Long studentId) {
//       var events= registrationEventRepository.findAll();
//       // var event=events.stream().filter(y->y.getRegistrationGroups().stream().map(x->x.getStudents().stream().flatMap(z->z.getStudentId().equals(studentId)))).findFirst().get();
//        return null;
//    }

    @Override
    public RegistrationEventDTO addNewRegistrationEvent(RegistrationEvent registrationEvent) {

        return modelMapper.map(registrationEventRepository.save(registrationEvent),RegistrationEventDTO.class);
    }

//    @Override
//    public RegistrationEventDTO updateRegistrationEvent(Long registrationId, RegistrationEvent registrationEvent) {
//        return null;
//    }

//    @Override
//    public RegistrationEventDTO updateRegistrationEvent(Long registrationId, RegistrationEvent registrationEvent) {
//       var updateRegEventDto= registrationEventRepository.findById(registrationId);
//        RegistrationEvent event=null;
//        if (updateRegEventDto.isPresent()){
//            event=updateRegEventDto.stream().map(
//                    newRegEvent->{
//                        newRegEvent.setId(registrationEvent.getId());
//                        newRegEvent.setStartDate(registrationEvent.getStartDate());
//                        newRegEvent.setEndDate(registrationEvent.getEndDate());
//                        newRegEvent.setRegistrationEventStatus(registrationEvent.getRegistrationEventStatus());
//                        newRegEvent.setRegistrationGroups(registrationEvent.getRegistrationGroups());
//                        return newRegEvent;
//                    }).findFirst().get();
//        }
//         registrationEventRepository.save(event);
//        return modelMapper.map(registrationEvent,RegistrationEventDTO.class);
//    }

    @Override
    public void deleteById(Long registrationEventId) {
registrationEventRepository.deleteById(registrationEventId);
    }


}

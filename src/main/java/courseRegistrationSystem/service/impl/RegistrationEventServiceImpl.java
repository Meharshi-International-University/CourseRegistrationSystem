package courseRegistrationSystem.service.impl;

import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.domain.RegistrationGroup;
import courseRegistrationSystem.dto.RegistrationDTO;
import courseRegistrationSystem.dto.RegistrationEventDTO;
import courseRegistrationSystem.repository.RegistrationEventRepository;
import courseRegistrationSystem.repository.RegistrationGroupRepository;
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
    RegistrationEventRepository registrationEventRepository;



    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RegistrationGroupRepository registrationGroupRepository;
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
                    return registrationGroupRepository.findById(r.getRegistrationGroupId())
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

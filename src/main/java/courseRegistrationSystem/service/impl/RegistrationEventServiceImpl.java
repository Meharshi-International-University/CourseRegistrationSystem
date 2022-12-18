package courseRegistrationSystem.service.impl;

import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.dto.RegistrationEventDTO;
import courseRegistrationSystem.enums.RegistrationEventStatus;
import courseRegistrationSystem.repository.RegistrationEventRepository;
import courseRegistrationSystem.service.RegistrationEventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RegistrationEventServiceImpl implements RegistrationEventService {
    @Autowired
    RegistrationEventRepository registrationEventRepository;
    @Autowired
    private ModelMapper modelMapper;
//    private RegistrationEventStatus status;
    @Override
    public List<RegistrationEventDTO> getAllRegistrationEvents() {
        return registrationEventRepository.findAll().stream()
                .map(registrationEvent -> modelMapper.map(registrationEvent, RegistrationEventDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public RegistrationEventDTO registrationStatus(RegistrationEventStatus status ) {
        LocalDateTime dateTime= LocalDateTime.now();
        RegistrationEventDTO eventDTO= new RegistrationEventDTO();
        if (dateTime.isBefore(eventDTO.getEndDate())&& dateTime.isAfter(eventDTO.getStartDate())){
          status=RegistrationEventStatus.PROGRESS;
        } else if (dateTime.equals(eventDTO.getStartDate())) {
            status=RegistrationEventStatus.OPEN;
        }else{
            status=RegistrationEventStatus.CLOSED;
        }
        return eventDTO;
    }
    @Override
    public RegistrationEventDTO getRegistrationEventBy_Id(Long registrationEventId) {
        return modelMapper.map(registrationEventRepository.findById(registrationEventId),RegistrationEventDTO.class);
    }

    @Override
    public RegistrationEventDTO addNewRegistrationEvent(RegistrationEvent registrationEvent) {

        return modelMapper.map(registrationEventRepository.save(registrationEvent),RegistrationEventDTO.class);
    }

    @Override
    public RegistrationEventDTO updateRegistrationEvent(Long registrationId, RegistrationEvent registrationEvent) {
       var updateRegEventDto= registrationEventRepository.findById(registrationId);
        RegistrationEvent event=null;
        if (updateRegEventDto.isPresent()){
            event=updateRegEventDto.stream().map(
                    newRegEvent->{
                        newRegEvent.setId(registrationEvent.getId());
                        newRegEvent.setStartDate(registrationEvent.getStartDate());
                        newRegEvent.setEndDate(registrationEvent.getEndDate());
                        newRegEvent.setRegistrationEventStatus(registrationEvent.getRegistrationEventStatus());
                        newRegEvent.setRegistrationGroups(registrationEvent.getRegistrationGroups());
                        return newRegEvent;
                    }).findFirst().get();
        }
         registrationEventRepository.save(event);
        return modelMapper.map(registrationEvent,RegistrationEventDTO.class);
    }

    @Override
    public void deleteById(Long registrationEventId) {
registrationEventRepository.deleteById(registrationEventId);
    }


}

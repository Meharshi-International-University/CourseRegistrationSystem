package courseRegistrationSystem.service.impl;

import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.dto.RegistrationDTO;
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
import java.util.stream.Collectors;

@Service
@Transactional
public class RegistrationEventServiceImpl implements RegistrationEventService {
    @Autowired
    private RegistrationEventRepository registrationEventRepository;
    
      private RegistrationEventStatus status;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<RegistrationEventDTO> getAllRegistrationEvents() {
        return registrationEventRepository.findAll().stream()
                .map(registrationEvent -> modelMapper.map(registrationEvent, RegistrationEventDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public void registrationEventStatus( RegistrationEvent event) {
        //RegistrationEvent event = new RegistrationEvent();

        LocalDateTime dateTime= LocalDateTime.now();
        
        if(dateTime.isBefore(event.getEndDate()) && dateTime.isAfter(event.getStartDate())){
             status = RegistrationEventStatus.OPEN;
        } else if (dateTime.equals(event.getStartDate())) {
           status=RegistrationEventStatus.OPEN;
        }else{
            status=RegistrationEventStatus.CLOSED;
        }


    }

    @Override
    public RegistrationEventDTO getRegistrationEventBy_Id(Long registrationEventId) {
        return null;
    }

    @Override
    public RegistrationEventDTO addNewRegistrationEvent(RegistrationEventDTO registrationEventDTO) {
        return null;
    }

    @Override
    public RegistrationEventDTO updateRegistrationEvent(Long registrationId, RegistrationEventDTO registrationEventDTO) {
        return null;
    }

    @Override
    public void deleteById(Long registrationEventId) {
registrationEventRepository.deleteById(registrationEventId);
    }


}

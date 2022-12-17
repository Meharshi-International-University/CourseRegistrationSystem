package courseRegistrationSystem.dto;

import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.service.Mapper;
import org.springframework.stereotype.Component;

@Component
public class MapperRegistration implements Mapper<Registration,RegistrationDto> {

    @Override
    //from normal to Dto
    public RegistrationDto mapTo(Registration entity) {
        RegistrationDto dto= new RegistrationDto();
        dto.setRegistrationId(entity.getRegistrationId());
        dto.setCourseOffering(entity.getCourseOffering());
        dto.setStudent(entity.getStudent());
        return dto;
    }
}

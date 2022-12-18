package courseRegistrationSystem.dto;

import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.service.Mapper;
import org.springframework.stereotype.Component;

@Component
public class MapperRegistration implements Mapper<Registration,RegistrationDTO> {

    @Override
    //from normal to Dto
    public RegistrationDTO mapTo(Registration entity) {
        RegistrationDTO dto= new RegistrationDTO();
        dto.setCourseOfferingDTO(entity.getCourseOffering());
        dto.setStudent(entity.getStudent());
        return dto;
    }
}

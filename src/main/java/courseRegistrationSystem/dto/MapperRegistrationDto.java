package courseRegistrationSystem.dto;

import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.service.Mapper;
import org.springframework.stereotype.Component;

@Component
public class MapperRegistrationDto implements Mapper<RegistrationDTO,Registration> {

    @Override
    public Registration mapTo(RegistrationDTO entity) {
        Registration dto = new Registration();
        dto.setCourseOffering(entity.getCourseOffering());
        dto.setStudent(entity.getStudent());
        return dto;
    }
}

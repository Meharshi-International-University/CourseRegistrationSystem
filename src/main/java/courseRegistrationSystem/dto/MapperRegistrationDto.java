package courseRegistrationSystem.dto;

import courseRegistrationSystem.domain.Registration;
import courseRegistrationSystem.service.Mapper;
import org.springframework.stereotype.Component;

@Component
public class MapperRegistrationDto implements Mapper<RegistrationDto,Registration> {

    @Override
    public Registration mapTo(RegistrationDto entity) {
        Registration dto = new Registration();
        dto.setRegistrationId(entity.getRegistrationId());
        dto.setCourseOffering(entity.getCourseOffering());
        dto.setStudent(entity.getStudent());
        return dto;
    }
}

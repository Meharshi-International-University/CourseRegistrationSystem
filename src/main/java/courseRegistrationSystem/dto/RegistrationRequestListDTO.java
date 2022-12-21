package courseRegistrationSystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Data
@Validated
public class RegistrationRequestListDTO {

    private Long studentId;

    private Long registrationEventId;

    @Valid
    private List<RegistrationRequestDTO> registrationRequestDTOList;
}

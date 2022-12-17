package courseRegistrationSystem.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RegistrationRequestDto {

    private int priorityNumber;

    private String studentId;

    private String courseOfferingCode;



}

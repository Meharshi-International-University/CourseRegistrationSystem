package courseRegistrationSystem.dto;




import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Data
public class RegistrationRequestDTO {

    private int priorityNumber;

    private String courseOfferringCode;
}

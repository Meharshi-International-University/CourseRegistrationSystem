package courseRegistrationSystem.DTO;

import courseRegistrationSystem.domain.RegistrationGroup;
import courseRegistrationSystem.enums.RegistrationEventStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class RegistrationEventDTO {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private List<RegistrationGroupDTO> registrationGroupDTOS = new ArrayList<>();
    private RegistrationEventStatus registrationEventStatus;

    public RegistrationEventDTO() {
    }

    public RegistrationEventDTO(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

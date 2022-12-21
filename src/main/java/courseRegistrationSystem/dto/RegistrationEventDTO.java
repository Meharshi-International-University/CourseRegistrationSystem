package courseRegistrationSystem.dto;

import courseRegistrationSystem.enums.RegistrationEventStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@ToString
public class RegistrationEventDTO {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private List<RegistrationGroupDTO> registrationGroups = new ArrayList<>();
    private RegistrationEventStatus registrationEventStatus;

    public RegistrationEventDTO() {
    }

    public RegistrationEventDTO(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

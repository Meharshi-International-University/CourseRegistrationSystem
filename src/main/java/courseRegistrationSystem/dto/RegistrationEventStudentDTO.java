package courseRegistrationSystem.dto;

import courseRegistrationSystem.enums.RegistrationEventStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RegistrationEventStudentDTO {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private List<RegistrationGroupAcademicDTO> registrationGroups = new ArrayList<>();
    private RegistrationEventStatus registrationEventStatus;

    public RegistrationEventStudentDTO() {
    }

    public RegistrationEventStudentDTO(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

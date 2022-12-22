package courseRegistrationSystem.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class RegistrationEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<RegistrationGroup> registrationGroups =new ArrayList<>();

    public RegistrationEvent() {
    }

    public RegistrationEvent(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void addRegistrationGroup(RegistrationGroup group) {
        registrationGroups.add(group);
    }
}

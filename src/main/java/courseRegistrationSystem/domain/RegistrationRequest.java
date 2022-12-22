package courseRegistrationSystem.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import courseRegistrationSystem.domain.pk.RegistrationRequestPK;
import courseRegistrationSystem.enums.RegistrationRequestStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@IdClass(RegistrationRequestPK.class)
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {


    private int priorityNumber;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseOfferingId")
   // @JsonIgnoreProperties("registrationRequests")
    @JsonBackReference(value = "registrationRequests")
    private  CourseOffering courseOffering;

    @ManyToOne(fetch = FetchType.LAZY)
    private RegistrationEvent registrationEvent;

    @Enumerated
    private RegistrationRequestStatus status = RegistrationRequestStatus.ONGOING;


    public RegistrationRequest(int priorityNumber, Student student, CourseOffering courseOffering, RegistrationEvent registrationEvent) {
        this.priorityNumber = priorityNumber;
        this.student = student;
        this.courseOffering = courseOffering;
        this.registrationEvent = registrationEvent;
    }


}

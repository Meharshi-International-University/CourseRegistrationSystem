package courseRegistrationSystem.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import courseRegistrationSystem.domain.pk.GenerateSequenceNumber;
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


    @OneToOne(cascade = CascadeType.ALL)
    private GenerateSequenceNumber randomId;

    public RegistrationRequest(int priorityNumber, Student student, CourseOffering courseOffering, RegistrationEvent registrationEvent) {
        this.priorityNumber = priorityNumber;
        this.student = student;
        this.courseOffering = courseOffering;
        this.registrationEvent = registrationEvent;
        this.randomId = new GenerateSequenceNumber();
    }


}

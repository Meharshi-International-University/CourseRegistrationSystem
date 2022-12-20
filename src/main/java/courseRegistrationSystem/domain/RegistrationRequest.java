package courseRegistrationSystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import courseRegistrationSystem.domain.pk.RegistrationRequestPK;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@IdClass(RegistrationRequestPK.class)
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    private int priorityNumber;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseOfferingId")
    @JsonIgnoreProperties("registrationRequests")
    private  CourseOffering courseOffering;


}

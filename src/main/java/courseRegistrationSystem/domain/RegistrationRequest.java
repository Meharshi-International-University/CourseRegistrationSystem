package courseRegistrationSystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class RegistrationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int priorityNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseOfferingId")
    @JsonIgnoreProperties("registrationRequests")
    private  CourseOffering courseOffering;


    public RegistrationRequest() {
    }

    public RegistrationRequest(int priorityNumber, Student student, CourseOffering courseOffering) {
        this.priorityNumber = priorityNumber;
        this.student = student;
        this.courseOffering = courseOffering;
    }
}

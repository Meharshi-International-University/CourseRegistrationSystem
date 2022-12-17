package courseRegistrationSystem.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class RegistrationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int priorityNumber;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "courseOfferingId")
    private  CourseOffering courseOffering;


    public RegistrationRequest() {
    }

    public RegistrationRequest(int priorityNumber, Student student, CourseOffering courseOffering) {
        this.priorityNumber = priorityNumber;
        this.student = student;
        this.courseOffering = courseOffering;
    }
}

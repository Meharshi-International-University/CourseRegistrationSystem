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
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "reg_courseOfferingId")
    private CourseOffering courseOffering;

    public Registration() {

    }

    public Registration( Student student, CourseOffering courseOffering) {
        this.student = student;
        this.courseOffering = courseOffering;
    }
}

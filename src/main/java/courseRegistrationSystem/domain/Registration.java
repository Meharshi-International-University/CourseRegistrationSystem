package courseRegistrationSystem.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @ManyToOne
    private Student student;

    @ManyToOne
    private CourseOffering CourseOffering;

    public Registration() {

    }

    public Registration( Student student, courseRegistrationSystem.domain.CourseOffering courseOffering) {
        this.student = student;
        CourseOffering = courseOffering;
    }
}

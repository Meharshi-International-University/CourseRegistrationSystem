package courseRegistrationSystem.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@ToString
@NoArgsConstructor
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseOfferingId")
   // @JsonIgnoreProperties("registrations")
    @JsonBackReference(value = "registrations")
    private CourseOffering courseOffering;

    public Registration( Student student, CourseOffering courseOffering) {
        this.student = student;
        this.courseOffering = courseOffering;
    }


}

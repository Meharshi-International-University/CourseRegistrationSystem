package courseRegistrationSystem.dto;

import courseRegistrationSystem.domain.CourseOffering;
import courseRegistrationSystem.domain.Student;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Setter
public class RegistrationDto {

    private Long registrationId;

    private Student student;

    private CourseOffering courseOffering;

    public RegistrationDto(Student student, CourseOffering courseOffering) {
        this.student = student;
        this.courseOffering = courseOffering;
    }
}

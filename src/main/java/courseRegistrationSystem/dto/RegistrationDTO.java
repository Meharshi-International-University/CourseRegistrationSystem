package courseRegistrationSystem.dto;

import courseRegistrationSystem.domain.CourseOffering;
import courseRegistrationSystem.domain.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDTO {
    private Student student;
    private CourseOffering courseOffering;

    public RegistrationDTO() {
    }

    public RegistrationDTO(Student student, CourseOffering courseOfferingDTO) {
        this.student = student;
        this.courseOffering = courseOfferingDTO;
    }
}

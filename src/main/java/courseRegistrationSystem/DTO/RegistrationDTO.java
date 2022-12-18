package courseRegistrationSystem.DTO;

import courseRegistrationSystem.domain.CourseOffering;
import courseRegistrationSystem.domain.Student;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDTO {
    private Student student;
    private CourseOfferingDTO courseOfferingDTO;

    public RegistrationDTO() {
    }

    public RegistrationDTO(Student student, CourseOfferingDTO courseOfferingDTO) {
        this.student = student;
        this.courseOfferingDTO = courseOfferingDTO;
    }
}

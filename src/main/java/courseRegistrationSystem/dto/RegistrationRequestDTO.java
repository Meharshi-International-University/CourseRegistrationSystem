package courseRegistrationSystem.DTO;

import courseRegistrationSystem.domain.CourseOffering;
import courseRegistrationSystem.domain.Student;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequestDTO {

    private int priorityNumber;

    private StudentDTO studentDTO;

    private CourseOfferingDTO courseOfferingDTO;

    public RegistrationRequestDTO() {
    }

    public RegistrationRequestDTO(int priorityNumber,
                                  StudentDTO studentDTO,
                                  CourseOfferingDTO courseOfferingDTO) {
        this.priorityNumber = priorityNumber;
        this.studentDTO = studentDTO;
        this.courseOfferingDTO = courseOfferingDTO;
    }
}

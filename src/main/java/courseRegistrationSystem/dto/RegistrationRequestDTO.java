package courseRegistrationSystem.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RegistrationRequestDTO {

    private int priorityNumber;

    private StudentDTO studentDTO;

    private CourseOfferingDTO courseOfferingDTO;

    private String studentId;

    private String courseOfferingCode;

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

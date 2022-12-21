package courseRegistrationSystem.dto;

import lombok.Data;

import java.util.List;

@Data
public class RegistrationStudentDTO {

    List<CourseOfferingDTO> courseOffering;
}

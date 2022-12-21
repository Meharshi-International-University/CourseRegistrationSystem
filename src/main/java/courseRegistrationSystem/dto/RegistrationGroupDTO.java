package courseRegistrationSystem.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationGroupDTO {
    private  Long registrationGroupId;
    private String name;
    private List<StudentDTO> students = new ArrayList<>();
    private List<AcademicBlockDTO> academicBlocks = new ArrayList<>();

    public RegistrationGroupDTO(List<StudentDTO> students, List<AcademicBlockDTO> academicBlocks) {
        this.students = students;
        this.academicBlocks = academicBlocks;
    }
}

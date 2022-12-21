package courseRegistrationSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationGroupAcademicDTO {
    private  Long registrationGroupId;
    private String name;
    //private List<StudentDTO> students = new ArrayList<>();
    private List<AcademicBlockDTO> academicBlocks = new ArrayList<>();


}

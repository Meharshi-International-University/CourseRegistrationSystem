package courseRegistrationSystem.DTO;

import courseRegistrationSystem.domain.AcademicBlock;
import courseRegistrationSystem.domain.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RegistrationGroupDTO {

    private List<StudentDTO> studentDTOS = new ArrayList<>();
    private List<AcademicBlockDTO> acadamicBlockDTOS = new ArrayList<>();

    public RegistrationGroupDTO() {
    }

    public RegistrationGroupDTO(List<StudentDTO> studentDTOS, List<AcademicBlockDTO> acadamicBlockDTOS) {
        this.studentDTOS = studentDTOS;
        this.acadamicBlockDTOS = acadamicBlockDTOS;
    }

    public void addStudentDTO(StudentDTO studentDTO){
        studentDTOS.add(studentDTO);
    }

    public void addAcademicBlockDTO(AcademicBlockDTO acadamicBlockDTO){
        acadamicBlockDTOS.add(acadamicBlockDTO);
    }



}

package courseRegistrationSystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RegistrationGroupDTO {


    private Long registrationGroupId;
    private List<StudentDTO> studentDTOS = new ArrayList<>();
    private List<AcademicBlockDTO> acadamicBlockDTOS = new ArrayList<>();

    public RegistrationGroupDTO() {
    }

    public RegistrationGroupDTO(Long registrationGroupId, List<StudentDTO> studentDTOS, List<AcademicBlockDTO> acadamicBlockDTOS) {
        this.registrationGroupId = registrationGroupId;
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

package courseRegistrationSystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RegistrationGroupDTO {


    private Long registrationGroupId;
    //private List<StudentDTO> students ;
    private List<AcademicBlockDTO> academicBlocks ;

    public RegistrationGroupDTO() {
    }

    public RegistrationGroupDTO(Long registrationGroupId, List<StudentDTO> studentDTOS, List<AcademicBlockDTO> acadamicBlockDTOS) {
        this.registrationGroupId = registrationGroupId;
       // this.students = studentDTOS;
        this.academicBlocks = acadamicBlockDTOS;
    }

    public Long getRegistrationGroupId() {
        return registrationGroupId;
    }

    public void setRegistrationGroupId(Long registrationGroupId) {
        this.registrationGroupId = registrationGroupId;
    }

//    public List<StudentDTO> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<StudentDTO> students) {
//        this.students = students;
//    }

    public List<AcademicBlockDTO> getAcademicBlocks() {
        return academicBlocks;
    }

    public void setAcademicBlocks(List<AcademicBlockDTO> academicBlocks) {
        this.academicBlocks = academicBlocks;
    }
}

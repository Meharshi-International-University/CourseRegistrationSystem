package courseRegistrationSystem.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class RegistrationGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationGroupId;

    @OneToMany
    private List<Student> students;
    @OneToMany
    private List<AcademicBlock> academicBlocks;

    public RegistrationGroup() {
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void addAcademicBlock(AcademicBlock academicBlock){
        academicBlocks.add(academicBlock);
    }

}

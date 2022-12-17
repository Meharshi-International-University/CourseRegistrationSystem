package courseRegistrationSystem.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class RegistrationGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationGroupId;

    @OneToMany
    @JoinColumn(name = "RegistrationGroupId")
    @OrderColumn(name="sequence")
    private List<Student> students= new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "RegistrationGroupId")
    @OrderColumn(name="sequence")
    private List<AcademicBlock> academicBlocks= new ArrayList<>();

    public RegistrationGroup() {
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void addAcademicBlock(AcademicBlock academicBlock){
        academicBlocks.add(academicBlock);
    }

}

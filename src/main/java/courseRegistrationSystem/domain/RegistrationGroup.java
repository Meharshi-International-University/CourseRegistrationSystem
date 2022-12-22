package courseRegistrationSystem.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@Setter
public class RegistrationGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationGroupId;
private String name;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "RegistrationGroupId")
    @OrderColumn(name="sequence")
    private List<Student> students;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "RegistrationGroupId")
    @OrderColumn(name="sequence")
    private List<AcademicBlock> academicBlocks= new ArrayList<>();

    public RegistrationGroup() {
    }

    public RegistrationGroup(String name) {
        this.name = name;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void addAcademicBlock(AcademicBlock academicBlock){
        academicBlocks.add(academicBlock);
    }

}

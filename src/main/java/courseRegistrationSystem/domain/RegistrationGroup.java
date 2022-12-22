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
    @Column(unique=true)
    private String name;

    @OneToMany
    private List<Student> students= new ArrayList<>();
    @OneToMany
   // @JoinColumn(name = "registrationGroupId")
   // @OrderColumn(name="sequence")
    private List<AcademicBlock> academicBlocks= new ArrayList<>();

    public RegistrationGroup() {
    }

    public RegistrationGroup(String name) {
        this.name = name;
    }

}

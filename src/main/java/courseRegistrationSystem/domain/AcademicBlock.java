package courseRegistrationSystem.domain;


import courseRegistrationSystem.enums.Semester;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="academicblock")
@ToString
@NoArgsConstructor
@Setter
@Getter
public class AcademicBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String blockCode;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @OneToMany(mappedBy = "academicBlock")
    @OrderColumn(name="sequence")
private List<CourseOffering> courseOfferings;
    public String getBlockName(){
        return this.name;
    }
    @Enumerated
    private Semester semester;
    public AcademicBlock(String blockCode, String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.blockCode = blockCode;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

package courseRegistrationSystem.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String semester;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @OneToMany()
    @OrderColumn(name="sequence")
    @JsonIgnoreProperties("academicBlock")
private List<CourseOffering> courseOfferings;
    public String getBlockName(){
        return this.semester;
    }
//    @Enumerated
//    private Semester semester;
    public AcademicBlock(String blockCode, String semester, LocalDateTime startDate, LocalDateTime endDate) {
        this.blockCode = blockCode;
        this.semester = semester;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

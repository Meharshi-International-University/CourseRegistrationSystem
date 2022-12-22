package courseRegistrationSystem.domain;


import courseRegistrationSystem.enums.Semester;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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
    @Column(unique=true)
    private String blockCode;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

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

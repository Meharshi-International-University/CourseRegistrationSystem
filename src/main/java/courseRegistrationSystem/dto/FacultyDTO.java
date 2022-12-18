package courseRegistrationSystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacultyDTO {
    private Integer facultyId;
    private String name;
    private String title;

    public FacultyDTO(Integer facultyId, String name, String title) {
        this.facultyId = facultyId;
        this.name = name;
        this.title = title;
    }

    public FacultyDTO() {
    }
}

package courseRegistrationSystem.domain.pk;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import courseRegistrationSystem.domain.CourseOffering;
import courseRegistrationSystem.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RegistrationRequestPK implements Serializable {

    private Student student;

    private CourseOffering courseOffering;
}

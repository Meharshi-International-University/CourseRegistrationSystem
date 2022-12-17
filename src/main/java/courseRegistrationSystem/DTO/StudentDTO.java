package courseRegistrationSystem.DTO;

import courseRegistrationSystem.domain.Address;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    private String studentId;
    private String name;
    private AddressDTO mailAddressDTO;
    private AddressDTO homeAddressDTO;

    public StudentDTO() {
    }

    public StudentDTO(String studentId, String name, AddressDTO mailAddressDTO, AddressDTO homeAddressDTO) {
        this.studentId = studentId;
        this.name = name;
        this.mailAddressDTO = mailAddressDTO;
        this.homeAddressDTO = homeAddressDTO;
    }
}

package courseRegistrationSystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    private String studentId;
    private String name;
    private AddressDTO mailAddressDTO;
    private AddressDTO homeAddressDTO;

    private String email;
    public StudentDTO() {
    }

    public StudentDTO(String studentId, String name, AddressDTO mailAddressDTO, AddressDTO homeAddressDTO) {
        this.studentId = studentId;
        this.name = name;
        this.mailAddressDTO = mailAddressDTO;
        this.homeAddressDTO = homeAddressDTO;
    }

    public StudentDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

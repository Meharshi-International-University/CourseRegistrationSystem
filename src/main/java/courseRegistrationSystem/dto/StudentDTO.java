package courseRegistrationSystem.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDTO {
    private String studentId;
    private String name;
    private AddressDTO mailAddress;
    private AddressDTO homeAddress;

    public StudentDTO() {
    }

    public StudentDTO(String studentId, String name, AddressDTO mailAddressDTO, AddressDTO homeAddressDTO) {
        this.studentId = studentId;
        this.name = name;
        this.mailAddress = mailAddressDTO;
        this.homeAddress = homeAddressDTO;
    }
}

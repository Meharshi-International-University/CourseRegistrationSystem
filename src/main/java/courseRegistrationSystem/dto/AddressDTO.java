package courseRegistrationSystem.dto;

import courseRegistrationSystem.domain.City;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class AddressDTO {
    private String street;
    private String postalCode;
    private City city;

    public AddressDTO(String street, City city, String postalCode) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }
}

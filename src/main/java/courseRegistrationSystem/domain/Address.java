package courseRegistrationSystem.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
public class Address {
    private String street;
    private String city;
    private String state;
    private String countryRegion;
    private String postalCode;

    public Address() {
    }

    public Address(String street, String city, String state, String countryRegion, String postalCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.countryRegion = countryRegion;
        this.postalCode = postalCode;
    }
}

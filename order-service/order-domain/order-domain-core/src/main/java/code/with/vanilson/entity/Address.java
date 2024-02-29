package code.with.vanilson.entity;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Address {
    private final UUID uuid;
    private final String street;
    private final String postCode;
    private final String city;

    public Address(UUID uuid, String street, String postCode, String city) {
        this.uuid = uuid;
        this.street = street;
        this.postCode = postCode;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}

        Address address = (Address) o;

        if (!street.equals(address.street)) {return false;}
        if (!postCode.equals(address.postCode)) {return false;}
        return city.equals(address.city);
    }

    @Override
    public int hashCode() {
        int result = street.hashCode();
        result = 31 * result + postCode.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }
}

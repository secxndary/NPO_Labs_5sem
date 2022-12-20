package secxndary_framework.model;

import java.util.Objects;

public class Address {

    private String street;
    private String house;

    public Address(String street, String house) {
        this.street = street;
        this.house = house;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(house, address.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, house);
    }
}

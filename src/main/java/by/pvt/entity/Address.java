package by.pvt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String city;
    private String street;
    @Column(name = "number_house")
    private String numberHouse;
    @Column(name = "postal_code")
    private String postalCode;
}

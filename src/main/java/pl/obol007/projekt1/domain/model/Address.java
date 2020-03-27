package pl.obol007.projekt1.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter @Setter @ToString(exclude = "user") @EqualsAndHashCode(of="id")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String street;
    @Column(name = "building")
    String buildingNumber;
    @Column(name = "flat")
    String flatNumber;

    //String regZipCode = (?:[^\d]|^)(\d{2}\-\d{3})(?:[^\d]|$);
    String zipcode;

    String city;

    String country;

    Double longitude;
    Double latitude;

    @OneToOne
    private User user;

}

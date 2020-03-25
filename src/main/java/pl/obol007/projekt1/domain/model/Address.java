package pl.obol007.projekt1.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter @Setter @ToString @EqualsAndHashCode(exclude = "id")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable=false)
    String street;
    @Column(name = "building", nullable = false)
    String buildingNumber;
    @Column(name = "flat")
    String flatNumber;
    @Column(nullable = false)
    //String regZipCode = (?:[^\d]|^)(\d{2}\-\d{3})(?:[^\d]|$);
    String zipcode;
    @Column(nullable = false)
    String city;
    @Column(nullable = false)
    String country;

}

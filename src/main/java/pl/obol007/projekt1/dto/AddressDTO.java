package pl.obol007.projekt1.dto;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

@Data @ToString
public class AddressDTO {

    Long id;

    String street;

    String buildingNumber;

    String flatNumber;

    //String regZipCode = (?:[^\d]|^)(\d{2}\-\d{3})(?:[^\d]|$);
    String zipcode;

    String city;

    String country;

    Double longitude;
    Double latitude;


}

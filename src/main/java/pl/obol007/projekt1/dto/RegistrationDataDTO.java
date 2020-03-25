package pl.obol007.projekt1.dto;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.ScriptAssert;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data @ToString(exclude = "password")
//Walidacja hasla
//@ScriptAssert(lang="avascript", script ="_this.password.equals(_this.rePassword")
public class RegistrationDataDTO {

    //DTO - data transfer object
    //DTO w kontrolerze i na jsp
    //do pobierania i wyswietlania danych
    //Dane z DTO mozemy uzyc do kilku encji,

    @NotBlank @Size(min=3, max=12)
    private String username;
    @NotBlank @Size(min=3, max=12)
    private String password;
    private String firstName;
    private String lastName;
    @NotBlank @Email
    private String email;
    @NotBlank
    private String role;
    //////////
//    @NotBlank
//    String street;
//    @NotBlank
//    String buildingNumber;
//    String flatNumber;
//    @NotBlank
//    String zipcode;
//    @NotBlank
//    String city;
//    @NotBlank
//    String country;
//    @NotBlank
//    String nip;
}

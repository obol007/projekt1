package pl.obol007.projekt1.dto;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.pl.NIP;
import pl.obol007.projekt1.domain.model.Address;
import pl.obol007.projekt1.domain.model.Product;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data @ToString(exclude = "password")
//Walidacja hasla
//@ScriptAssert(lang="javascript", script ="_this.password.equals(_this.rePassword")
public class BusinessRegistrationDTO {

    //DTO - data transfer object
    //DTO w kontrolerze i na jsp
    //do pobierania i wyswietlania danych
    //Dane z DTO mozemy uzyc do kilku encji,

    @NotBlank
    @Size(min=3, max=12)
    private String username;
    @NotBlank @Size(min=3, max=12)
    private String password;
    private Boolean active = false;
    @NotBlank
    private final String role = "ROLE_BUSINESS";

    private String firstName;
    private String lastName;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(min=3, max=20)
    private String businessName;
    private Boolean visible = false;
    @NIP
    private String nip;
    @NotBlank
    String category;
//    @Pattern("(?:[^\d]|^)(\d{2}\-\d{3})(?:[^\d]|$)");


   private Address address;



}

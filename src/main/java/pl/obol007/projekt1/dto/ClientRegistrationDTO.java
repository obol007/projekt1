package pl.obol007.projekt1.dto;

import lombok.Data;
import lombok.ToString;
import pl.obol007.projekt1.domain.model.Address;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@ToString(exclude = "password")
public class ClientRegistrationDTO {

    private final String role = "ROLE_CLIENT";
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @NotBlank
    String username;
    @NotBlank @Size(min=3, max=12)
    private String password;
    @NotBlank
    @Email
    String email;
    private Boolean active = false;

    @ManyToOne
    Address address;


}

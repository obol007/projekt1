package pl.obol007.projekt1.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Getter @Setter @ToString @EqualsAndHashCode(of="id")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private final String role = "CLIENT";
    @Column(nullable = false, name = "name")
    String firstName;
    @Column(nullable = false, name = "surname")
    String lastName;
    @Column(nullable = false)
    String username;
    @Column(nullable = false)
    @Email
    String email;

    @ManyToOne
    Address address;

}

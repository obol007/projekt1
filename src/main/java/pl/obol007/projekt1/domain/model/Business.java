package pl.obol007.projekt1.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.pl.NIP;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @ToString(exclude = "password") @EqualsAndHashCode(of="id")

public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private final String role = "BUSINESS";
//    @Column(nullable = false, unique = true)
//    private String username;
    @Column(nullable = false, unique = true, name = "name")
    private String businessName;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
//    @Column(nullable = false)
//    private String password;
//    @Column(nullable = false)
//    private Boolean active = false;
    private Boolean visible = false;
    @Column(nullable = false, unique = true)
    @NIP
    private String nip;
    @Column(nullable = false)
    String category;

    @OneToOne
    private User user;

    @ManyToOne
    private Address address;

    @ManyToMany
    private List<Product> products;




}

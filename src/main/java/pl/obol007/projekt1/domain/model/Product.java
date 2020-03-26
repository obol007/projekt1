package pl.obol007.projekt1.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString (exclude = "business") @EqualsAndHashCode(of="id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String category;
    @Column(nullable = false)
    Double price;
    @Column(nullable = false)
    Integer quantity;
    String description;

    @ManyToOne
    Business business;

}

package pl.obol007.projekt1.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter @EqualsAndHashCode @ToString //-> parametr dla klasy, ktora dziedziczy(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //techniczne informacje, nie biznesowe (zgloszenie moze przyjsc
    //wczesniej, niz zaczniemy edytowac baze
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdOn;

    @LastModifiedDate
    private LocalDateTime updatedOn;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String updatedBy;

    //   FETCHOWANIE UZYWAJAC REPOSITORY
//    @EntityGraph(attributePaths = ("authors"), type= EntityGraph.EntityGraphType.FETCH)
//    List<Project> findAllWithAuthorBy();

}

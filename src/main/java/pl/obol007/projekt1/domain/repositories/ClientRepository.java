package pl.obol007.projekt1.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.obol007.projekt1.domain.model.Business;
import pl.obol007.projekt1.domain.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByUserId(Long id);


}

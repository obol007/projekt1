package pl.obol007.projekt1.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.obol007.projekt1.domain.model.Business;
import pl.obol007.projekt1.domain.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByUserId(Long id);

    @Query("select c from Client c join User u on c.user.id = u.id where u.username= ?1")
    Client findByUsername(String username);


}

package pl.obol007.projekt1.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.obol007.projekt1.domain.model.Business;

public interface BusinessRepository extends JpaRepository<Business, Long> {

Business findByUserId(Long id);

    @Query("select b from Business b join User u on b.user.id = u.id where u.username = ?1")
    Business findByUsername(String username);


}

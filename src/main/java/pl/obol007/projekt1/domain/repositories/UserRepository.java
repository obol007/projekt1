package pl.obol007.projekt1.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.obol007.projekt1.domain.model.User;

public interface UserRepository extends JpaRepository <User,Long > {

    User findByUsername(String username);
}

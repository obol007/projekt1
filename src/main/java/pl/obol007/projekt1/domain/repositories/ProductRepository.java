package pl.obol007.projekt1.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.obol007.projekt1.domain.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

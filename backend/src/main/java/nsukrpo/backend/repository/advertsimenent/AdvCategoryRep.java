package nsukrpo.backend.repository.advertsimenent;

import nsukrpo.backend.model.entities.advertisement.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdvCategoryRep extends CrudRepository<Category, Long> {
    Optional<Category> findByName(String name);
    Optional<Category> findById(Long id);

}

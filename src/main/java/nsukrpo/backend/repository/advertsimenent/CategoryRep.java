package nsukrpo.backend.repository.advertsimenent;

import nsukrpo.backend.model.entities.advertisement.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRep extends CrudRepository<Category, Long> {

}

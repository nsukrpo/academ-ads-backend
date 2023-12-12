package nsukrpo.backend.repository.advertsimenent;

import nsukrpo.backend.model.entities.advertisement.Advertisement;
import nsukrpo.backend.model.entities.advertisement.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRep extends CrudRepository<Category, Long> {

}

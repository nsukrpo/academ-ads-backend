package nsukrpo.backend.repository.advertsimenent;

import nsukrpo.backend.model.entities.advertisement.AdPhoto;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRep extends CrudRepository<AdPhoto, Long> {
}

package nsukrpo.backend.repository.advertsimenent;

import nsukrpo.backend.model.entities.advertisement.Category;
import nsukrpo.backend.model.entities.advertisement.StatusAd;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdvStatusRep extends CrudRepository<StatusAd, Long> {
    Optional<StatusAd> findByName(String name);
}

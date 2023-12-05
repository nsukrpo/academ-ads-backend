package nsukrpo.backend.repository;

import nsukrpo.backend.model.entities.advertisement.StatusAd;
import org.springframework.data.repository.CrudRepository;

public interface StatusAdRep extends CrudRepository<StatusAd, Long> {
    

}

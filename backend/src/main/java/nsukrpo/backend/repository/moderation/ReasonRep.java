package nsukrpo.backend.repository.moderation;

import nsukrpo.backend.model.entities.moderation.Reason;
import org.springframework.data.repository.CrudRepository;

public interface ReasonRep extends CrudRepository<Reason, Long> {
    Reason findByName(String name);
}

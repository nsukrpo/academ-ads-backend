package nsukrpo.backend.repository.moderation;

import nsukrpo.backend.model.entities.moderation.Reason;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReasonRep extends CrudRepository<Reason, Long> {
    Optional<Reason> findByName(String name);
}
